# Foundation

**Warning: This is early days for Foundation. I created it after spending an
afternoon setting yet another Clojure project up, and decided to store this work
somewhere so I will not repeat it again in the future. So all the usual
disclaimers apply: rough edges, missing functionality, use at your own risk,
etc.**

This is a Clojure project set up minimally. It is meant to serve as the
Foundation for other projects. By minimally I mean a standard HTTP server, a
Component-based architecture, using the
[reloaded](http://thinkrelevance.com/blog/2013/06/04/clojure-workflow-reloaded)
pattern, and a way to configure enviroments. It has been heavily inspired by
[Edge](https://github.com/juxt/edge).

The libraries included are:

- [Aero](https://github.com/juxt/aero) for configuration.
- [Component](https://github.com/stuartsierra/component) with two components set
  up, one for the web server and another for a generic database store. At the
  moment this store is just an atom.
- [Compojure](https://github.com/weavejester/compojure) for routing.
- [Ring](https://github.com/ring-clojure) for the HTTP abstraction, using Jetty
  as the default web server.

## Installation

Clone and rename :)

## Usage

Fire up a REPL, and hit `(reset)`. You should be up and running.

## License

Copyright © 2017 Nikos Fertakis

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
