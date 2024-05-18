const presetQuick = require("franken-ui/shadcn-ui/preset-quick");
const defaultTheme = require('tailwindcss/defaultTheme')
const {scanClojure} = require('@multiplyco/tailwind-clj');

module.exports = {
    // in prod look at shadow-cljs output file in dev look at runtime, which will change files that are actually compiled; postcss watch should be a whole lot faster
    // content: {
    //     files: [
    //         './src/**/*.{clj,cljs,cljc}'
    //     ],
    //     extract: {
    //         clj: (content) => scanClojure(content),
    //         cljs: (content) => scanClojure(content),
    //         cljc: (content) => scanClojure(content)
    //     }
    // },
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