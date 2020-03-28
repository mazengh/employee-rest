module.exports = {
  root: true,
  env: {
    node: true
  },
  plugins: ["vue"],
  extends: ["plugin:vue/recommended"],
  rules: {
    "no-console": process.env.NODE_ENV === "production" ? "warn" : "off",
    "no-debugger": process.env.NODE_ENV === "production" ? "error" : "off",
    "vue/name-property-casing": ["error", "kebab-case"],
    "vue/no-v-html": "off"
  },
  parserOptions: {
    parser: "babel-eslint"
  }
};
