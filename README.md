# conjurernix/electric-franken

Thin macro-based API for using FrankenUI in Clojure Electric. This library includes macro-based wrappers for components,
modifiers, and other utilities and helpers.

## Installation

### Franken/Tailwind
First you have to setup your project to use Tailwind and Franken. Directions for installing Franken can be found
[here](https://www.franken-ui.dev/docs/installation). For an example on how to do it in a Clojure codebase
with `shadow-cljs`
checkout the example directory. Your `tailwind.config.js` (if any) should look something like that:

```javascript
const presetQuick = require("franken-ui/shadcn-ui/preset-quick");
const defaultTheme = require('tailwindcss/defaultTheme')

module.exports = {
    // TODO: Replace this with your own compiled javascript files.
    content: ["./resources/public/electric_starter_app/js/**/*.js"],
    theme: {
        extend: {
            fontFamily: {
                sans: ["Inter var", ...defaultTheme.fontFamily.sans],
            },
        },
    },
    plugins: [
        require('@tailwindcss/forms'),
    ],
    presets: [presetQuick()]
}
```

Since Clojurescript will compile to lots of `.js` files it is possible that you'll have a slow build of your css files.
An alternative approach is to copy the source code, since it's a simple single-namespaced library, into your own
project,
and configure `tailwind.config.js` to parse straight clj(s) code, using `@multiplyco/tailwind-clj`.
This will reduce significantly your tailwind build times.

```javascript
const presetQuick = require("franken-ui/shadcn-ui/preset-quick");
const defaultTheme = require('tailwindcss/defaultTheme')
const {scanClojure} = require('@multiplyco/tailwind-clj');

module.exports = {
    // in prod look at shadow-cljs output file in dev look at runtime, which will change files that are actually compiled; postcss watch should be a whole lot faster
    content: {
        files: [
            './src/**/*.{clj,cljs,cljc}'
        ],
        extract: {
            clj: (content) => scanClojure(content),
            cljs: (content) => scanClojure(content),
            cljc: (content) => scanClojure(content)
        }
    },
    theme: {
        extend: {
            fontFamily: {
                sans: ["Inter var", ...defaultTheme.fontFamily.sans],
            },
        },
    },
    plugins: [
        require('@tailwindcss/forms'),
    ],
    presets: [presetQuick()]
}
```
### electric-franken clojars

You can find the library on [clojars](https://clojars.org/io.github.conjurernix/electric-franken).

### Stack Overflow

Since it's a macro-based API, you might have Stack Overflow errors at compile time, trying to expand all those macros
into,
other macros etc. You can solve that by increasing the stack size of the JVM using `-Xss4m`.

For example in your `deps.edn`

```clojure
:jvm-opts ["-Xss4m"]
```

## Usage

This provides a very thin and practical API for use in Clojure electric, so anything in
the [official Franken docs](https://www.franken-ui.dev/docs/introduction) applies.

A simple example followed by some explanation:

```clojure
(ui/Inline
  (ui/Button (dom/text "Click to drop!"))
  (ui/Dropbar
    (ui/dropbar-top)
    (ui/drop {:mode    "click"
              :pos     "top-right"
              :stretch "x"})

    (ui/Card
      (ui/card-body)
      (ui/CardTitle (dom/text "Dropped!"))
      (dom/text "because you clicked."))))
```

Here, the use of capitalised macros like `ui/Inline` and `ui/Button` are the wrappers of the respective Franken
components. `ui/dropbar-top` is a helper, that adds the class `uk-dropbar-top` to the encapsulating element,
the `ui/Dropbar`.
`ui/drop` adds the `uk-drop` attribute with the options set as in the map.

### Examples

You can take a close look at the [examples](./examples/src/electric_starter_app/main.cljc)(which are WIP), and also run
them locally:

```shell
cd examples
clj -A:dev -X dev/-main
```

and in another shell

```shell
npm run postcss:watch
```

You should be able to access them in your browser at `localhost:8080`.

## Contributing

It's very possible that I might have missed a component/modifier/directive wrapper. If so please feel free to contribute
by
adding anything missing. You should first read a little bit the source code in `conjurernix.electric-franken.api` so
that you
understand the idioms used and follow them.

I stopped recreating the examples from the Franken docs halfway through, but feel free to add more examples if you want.
We'd also like to add some more dynamic examples than just putting elements on the DOM at some point.

## TODO

- [ ] Finish examples for all components and modifiers
- [ ] Improve examples by having the preview of the example and the markup next to it (similar to Franken's docs).

## License

Copyright © 2024 Nikolas Pafitis
Distributed under the Eclipse Public License version 1.0.
