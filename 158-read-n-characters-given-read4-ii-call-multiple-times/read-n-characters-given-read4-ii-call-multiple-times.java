/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] interalBuffer = new char[4];
    int internalBufferPointer = 0;
    int internalBufferSize = 0;
    public int read(char[] buf, int n) {
        int externalBufferPointer = 0;

        while(externalBufferPointer < n){
            // if internal is not yet populated or is completely traversed and we want to refill it.
            if(internalBufferPointer == 0){
                // this populates the internal buffer upto 4 characters length of characters if they're less than 4
                // and returns the pointer location after the fill
                internalBufferSize = read4(interalBuffer);
            }
            //no more chars left to buffer
            if(internalBufferSize == 0)break;

            // populate external buffer referencing the pointers of external buffer
            while(externalBufferPointer < n && internalBufferPointer < internalBufferSize){
                buf[externalBufferPointer++] = interalBuffer[internalBufferPointer++];
            }
            // reset the internal so that we can refill internal buffer with read4 call
            if(internalBufferPointer>=internalBufferSize) internalBufferPointer =0;

        }

     return externalBufferPointer;
    }
}