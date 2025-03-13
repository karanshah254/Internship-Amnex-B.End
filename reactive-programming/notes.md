# What is reactive programming ?
- >Reactive programming in Java is a style of programming that uses asynchronous data streams to build responsive applications. It's used to handle events and data streams without blocking, which makes applications more efficient and scalable.

#### Core features
1. New programming paradigm
2. asynchronous and non blocking
3. functional style code
4. data flow as event driven stream (when any event occurs it immediately reflect the changes to both client and server)
5. backpressure on data streams (when huge data is being pushed to client it needs to be handles such that application performance is same ).

#### Basic example:
- >In hotel or food stall multiple orders are taken by person itself and cook based on priority.

#### Points
1. Thread per request model: Traditional REST API
- >Each time only single thread/request is accepted and response is given. It has thread pool count (n). If n reaches its max value then no more request is being catered and external db block or exit the connection.
- >This is old approach and thus **reactive programming** comes into the picture.

2. Reactive programming thread processing
- >Here request is being processed freely without any load on server or DB and response is given whenever available

#### Code based working
- >Here we use MONO or FLUX as data type for API call return response.

#### Reactive stream specification
- >It has: 1. Publisher 2. Subscriber 3. Subscripton 4. Processor
- >Publisher: It always publish an event
- >Subscriber: It will consume an event from publisher
- >Subscription: It represent unique relationship between subscriber and publisher.
- >Processor: It represent a processing stage - which both publisher and subscriber obeys.

### Library to be used
- >Highly recommended is Project Reactor