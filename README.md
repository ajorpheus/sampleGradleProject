# Bounded Queue

## Install in Linux or Mac with Gradle

1. Make sure you have java version 1.7 or 1.8. To check open up a new terminal and type:
   ```sh
   prompt> java -version
   ```  
   If you don't have java 1.7 install it by going [
   here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). 
   After installing java 1.7 open up a new terminal to check if java 1.7 is 
   installed by retyping `java -version` in the terminal.

2. To run all of the code in the Linux or Mac terminal type:
   ```sh
   prompt/Queue> ./gradlew build
   BUILD SUCCESSFUL # If you see `BUILD SUCCESSFUL` all of the tests have passed! 
   ```

## Implementation strategy
To optimize for algorithmic runtime, memory usage, and memory throughput. I
have implemented the bounded queue as an array based circular queue.  
  
By implementing the queue as drifting within a circular array both the 
`enqueue()` and `dequeue()` methods will have O(1) or constant runtime.

Additionally an array based implementation of a Queue has been used over a 
linked list implementation of a Queue to optimize memory usage. Since the Queue 
will be holding small elements(4 byte integers) and the constructor requires
a size we can assume the purpose of this bounded Queue is to store
a known max size of integers. By not using the pointers used in a linked list
Queue this array based Queue is more space efficient if the maxSize
of the Queue is known initially.