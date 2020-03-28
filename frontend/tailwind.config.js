module.exports = {
  theme: {
    screens: {
      xs: "320px",
      sm: "480px",
      md: "768px",
      lg: "1024px",
      xl: "1280px"
    },
    fontFamily: {
      body: [
        "Roboto",
        "-apple-system",
        "BlinkMacSystemFont",
        '"Segoe UI"',
        '"Helvetica Neue"',
        "Arial",
        '"Noto Sans"',
        "sans-serif",
        '"Apple Color Emoji"',
        '"Segoe UI Emoji"',
        '"Segoe UI Symbol"',
        '"Noto Color Emoji"'
      ],
      headings: [
        "Roboto",
        "-apple-system",
        "BlinkMacSystemFont",
        '"Segoe UI"',
        '"Helvetica Neue"',
        "Arial",
        '"Noto Sans"',
        "sans-serif",
        '"Apple Color Emoji"',
        '"Segoe UI Emoji"',
        '"Segoe UI Symbol"',
        '"Noto Color Emoji"'
      ],
      icons: ['"Font Awesome 5 Free"', "sans-serif"]
    },
    fontSize: {
      xs: "0.75rem",
      sm: "0.875rem",
      base: "1rem",
      lg: "1.125rem",
      xl: "1.25rem",
      "2xl": "1.5rem",
      "3xl": "1.875rem",
      "4xl": "2.25rem",
      "5xl": "3rem",
      "6xl": "3.875rem"
    },
    fontWeight: {
      light: "300",
      normal: "400",
      medium: "500",
      semibold: "600",
      bold: "700"
    },
    extend: {
      minWidth: {
        xs: "20rem",
        sm: "24rem",
        "0": "0",
        "1/4": "25%",
        "1/2": "50%",
        "3/4": "75%",
        full: "100%"
      },
      minHeight: {
        xs: "20rem",
        sm: "24rem",
        "0": "0",
        "1/4": "25%",
        "1/2": "50%",
        "3/4": "75%",
        full: "100%"
      },
      colors: {
        // base color palette
        white: "#ffffff",
        black: "#1a202c",
        outline: "rgba(50, 150, 200, 0.2)",

        // application colors
        primary: "var(--color-primary)",
        secondary: "var(--color-secondary)",
        info: "var(--color-info)",
        correct: "var(--color-correct)",
        incorrect: "var(--color-incorrect)",
        success: "var(--color-correct)",
        error: "var(--color-incorrect)",
        disabled: "var(--color-disabled)",
        neutral: "var(--color-neutral)",
        background: theme => theme("colors.surface.base"),

        surface: {
          base: "var(--color-surface-base)",
          info: "var(--color-surface-info)",
          instruction: "var(--color-surface-instruction)",
          note: "var(--color-surface-note)",
          correct: "var(--color-surface-correct)",
          incorrect: "var(--color-surface-incorrect)",
          success: "var(--color-surface-correct)",
          error: "var(--color-surface-incorrect)",
          disabled: "var(--color-surface-disabled)",
          primary: "var(--color-surface-primary)",
          secondary: "var(--color-surface-secondary)",
          tertiary: "var(--color-surface-tertiary)",
          neutral: "var(--color-surface-neutral)"
        },

        on: {
          light: "var(--color-on-light)",
          dark: "var(--color-on-dark)",
          base: "var(--color-on-light)",
          info: "var(--color-on-light)",
          instruction: "var(--color-instruction)",
          note: "var(--color-note)",
          correct: "var(--color-on-light)",
          incorrect: "var(--color-on-light)",
          success: "var(--color-on-light)",
          error: "var(--color-on-light)",
          disabled: "var(--color-on-light)",
          primary: "var(--color-on-dark)",
          secondary: "var(--color-on-dark)",
          tertiary: "var(--color-on-light)",
          neutral: "var(--color-on-dark)"
        }
      }
    }
  }
};
