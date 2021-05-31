package synthesizer;

//Make sure this class is public
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {

        int roundedInt = (int) Math.round((SR / frequency));
        this.buffer = new ArrayRingBuffer<>(roundedInt);
        while (!buffer.isFull()) {
            buffer.enqueue(0.0);
        }

    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {


        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }
        while (!buffer.isFull()) {
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }


        //
        //       Make sure that your random numbers are different from each other.
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {


        Double result1 = buffer.dequeue();
        Double result2 = buffer.peek();

        Double newValue = DECAY * (0.5 * (result1 + result2));
        buffer.enqueue(newValue);


    }

    /* Return the double at the front of the buffer. */
    public double sample() {
       
        return buffer.peek();
    }

}
