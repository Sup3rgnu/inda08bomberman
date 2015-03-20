How I made multiplayer bombing possible

# Introduction #

The Bomberman game starts with a server-client solution when connecting and then initiates a peer-to-peer protocol working as a token-ring. The protocol was designed to enforce equal bandwith latency for all players. It aims for as low latency as possible.

# Initiating the network #

1. A **server** is started and listens on TCP port 9889.
2. A **client** is started and connects to the server.
3. The **server** sends a _token package_

This is followed by ACK packages without a PSH as of standard TCP

# In-game communication #

**Clients** and **servers** are now technically called **peers**.

1. The **client** responds and sends a _pressed key_ or a _token package_
2. The **server** does as point 1.
and so the loop continues.

Alternatively, other **clients** may be added to the ring. Then **clients** needs to send packages to each other and the **server**. Therefore, all packages contain a _table_ with all known keys pressed lately. With each forwarding, the **peer** changes the _table_ due to its own key pressed.

# Shutting down the network #

Shutdown is defined by standard TCP. The **peers** may disconnect any way they want.


Caj