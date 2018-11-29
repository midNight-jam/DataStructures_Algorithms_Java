zz

## System Design Basics

Whenever we are designing a large system, we need to consider few things:

What are different architectural pieces that can be used?
How do these pieces work with each other?
How can we best utilize these pieces, what are the right tradeoffs?
Investing in scaling before it is needed is generally not a smart business proposition; however, some forethought into the design can save valuable time and resources in the future. In the following chapters, we will try to define some of the core building blocks of scalable systems. Familiarizing these concepts would greatly benefit in understanding distributed system concepts. In the next section, we will go through Consistent Hashing, CAP Theorem, Load Balancing, Caching, Data Partitioning, Indexes, Proxies, Queues, Replication, and choosing between SQL vs. NoSQL.

Let’s start with Load Balancing.

## Load Balancer

Load Balancer (LB) is another critical component of any distributed system. It helps to spread the traffic across a cluster of servers to , improve responsiveness & availablity of applications, websites or databases. LB also keeps track of status of all the resources while distributing requests . If a server is not available to take new requests or is not responding or has elevated error rate, LB will stop sending traffic to such a server.

Typically a load balancer sits between the client and the server accepting incoming network and application traffic and distributing the traffic across multiple backend servers using various algorithms. By balancing application requests across multiple servers, a load balancer reduces individual server load and prevents any one application server from becoming a single point of failure, thus improving overall application availability and responsiveness.

![alt text](https://github.com/midNight-jam/DataStructures_Algorithms_Java/blob/master/src/zzsd/lb1.png)
![Alt text](lb1.png?raw=true "Title")
![Image of Yaktocat](https://github.com/midNight-jam/DataStructures_Algorithms_Java/tree/master/src/zzsd/lb1.png)

To utilize full scalability and redundancy, we can try to balance the load at each layer of the system. We can add LBs at three places:

- Between the user and the web server
- Between web servers and an internal platform layer, like application servers or cache servers
- Between internal platform layer and database.
