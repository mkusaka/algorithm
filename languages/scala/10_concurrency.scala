// Runnable / Callable

trait Runnable { // single method, returns no value
  def run(): Unit
}

trait Callable[V] { // similar to runnnable which returns a value
  def call(): V
}

// Threads

val hello = new Thread(new Runnable {
  def run() {
    println("hello world")
  }
})

hello.start

// single thread

import java.net.{Socket, ServerSocket}
import java.util.concurrent.{Executors, ExecutorService}
import java.util.Date

class NetworkService(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)

  def run() {
    while(true) {
      val socket = serverSocket.accept()
      (new Thread(new Handler(socket))).start() // make thread for each request
      // (new Handler(socket)).run() // this process works always `main` thread
    }
  }
}

class Handler(socket: Socket) extends Runnable {
  def message = (Thread.currentThread.getName() + "\n").getBytes

  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}

(new NetworkService(2020, 2)).run
