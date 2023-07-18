window.addEventListener("load", () => {
  const themeBtn = document.querySelectorAll("[data-hs-theme-click-value]");
  let html = document.querySelector("html");

  themeBtn.forEach(($item) => {
    $item.addEventListener("click", () => {
      if (html.classList.contains("dark")) {
        html.classList.remove("dark");
        localStorage.clear();
        localStorage.removeItem("layout-theme");
        localStorage.removeItem("Syntodarktheme");
        localStorage.removeItem("SyntoMenu");
        localStorage.removeItem("SyntoHeader");
        html.setAttribute("data-menu-styles", "dark");
        html.setAttribute("data-header-styles", "light");
        html.style.removeProperty("--body-bg");
        html.style.removeProperty("--dark-bg");
        document.getElementById("switcher-light-theme").checked = true;
      } else {
        document.getElementById("switcher-dark-theme").checked = true;
        html.setAttribute("class", "dark");
        localStorage.clear();
        localStorage.setItem("layout-theme", "dark");
        html.setAttribute("data-header-styles", "dark");
        html.setAttribute("data-menu-styles", "dark");
        localStorage.removeItem("SyntoMenu");
        localStorage.removeItem("SyntoHeader");
        localStorage.setItem("Syntodarktheme", true);
        localStorage.setItem("SyntoMenu", "dark");
        localStorage.setItem("SyntoHeader", "dark");
      }
    });
  });
});
