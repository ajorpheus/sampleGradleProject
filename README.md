# Sample Gradle Project

This repo contains the basic files you need to build your Java code on 
Linux/Mac/Windows using a Gradle. If you don't know what Gradle is, it is 
basically a way to build your code on Linux/Mac/Windows easily. I prefer it 
over Ant or Maven for building Java code because you do <b>NOT</b> need to 
install Gradle in order to use it because you download a wrapper. This greatly 
simplifies the install process. As an example I have implemented a queue with 
a single test file to show how you want to organize your files. I have also
added a `Main.java` class for you to run your application. For larger 
Java projects take a look at the `build.gradle` file and file structure at this 
open source brain project: https://github.com/WalnutiQ/WalnutiQ

## How to run tests through command line in Linux/Mac/Windows with Gradle

1. Make sure you have java version 1.6, 1.7 or 1.8. To check open up a new 
   terminal and type:
   ```  
   prompt> java -version
   ```  
   If you don't have any of the above, install java 1.7 by going [
   here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). 
   After installing java 1.7 open up a new terminal to check if java 1.7 is 
   installed by retyping `java -version` in the terminal.

2. To run all tests in the Linux or Mac terminal type: 
   ```
   prompt/SampleGradleProject> ./gradlew clean # cleans old compiled code
   prompt/SampleGradleProject> ./gradlew test
   ```

3. To run all tests in the Windows command prompt type:
   ```
   prompt/SampleGradleProject> gradlew.bat clean 
   prompt/SampleGradleProject> gradlew.bat test
   ```

## How to run `Main.java` through command line in Linux/Mac/Windows with Gradle

1. First make sure the above instructions work.

2. Then on Linux or Mac terminal type:
   ```
   prompt/SampleGradleProject> ./gradlew run
   Yo what's up human! Oh you think you're fancy
   ```
3. And for Windows command prompt type:
   ```
   prompt/SampleGradleProject> gradlew.bat run
   Yo what's up human! Oh you think you're fancy
   ```

## Queue Implementation strategy
The `Queue.java` class is in `src/main/java/Queue.java`  
The `QueueTest.java` class is in `src/test/java/QueueTest.java`

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
