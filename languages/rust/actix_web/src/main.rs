use actix_web::{Error, FromRequest, Path, server, App, HttpRequest, Responder};
use serde_derive::*;

#[derive(Deserialize)]
struct HelloPath {
    name: String,
}

fn hello_name(req: &HttpRequest) -> Result<String, Error> {
    let to = Path::<HelloPath>::extract(req)?;
    Ok(format!("Hello {}!", &to.name))
}

fn hello(req: &HttpRequest) -> impl Responder {
    let to = req.match_info().get("name").unwrap_or("World");
    format!("Hello {}!", to)
}

fn main() {
    server::new(|| {
        App::new()
            .resource("/", |r| r.f(hello))
            .resource("/{name}", |r| r.f(hello))
    })
    .bind("localhost:3000")
    .expect("Can not bin to port 3000")
    .run();
}
