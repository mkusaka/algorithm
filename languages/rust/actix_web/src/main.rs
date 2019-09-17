use actix_web::{Path, server, App, HttpRequest, Responder};
use serde_derive::*;

#[derive(Deserialize)]
struct HelloPath {
    name: String,
}

fn hello_name(to: Path<HelloPath>) -> impl Responder {
    format!("Hello {}!", &to.name)
}

fn hello(req: &HttpRequest) -> impl Responder {
    let to = req.match_info().get("name").unwrap_or("World");
    format!("Hello {}!", to)
}

fn main() {
    server::new(|| {
        App::new()
            .resource("/", |r| r.f(hello))
            .resource("/{name}", |r| r.with(hello_name))
    })
    .bind("localhost:3000")
    .expect("Can not bin to port 3000")
    .run();
}
