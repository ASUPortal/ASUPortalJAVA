<%-- 
    Document   : public.template
    Created on : Jul 19, 2014, 9:58:52 PM
    Author     : aleksandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="asu" uri="/asu/tags" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><asu:settingStringValue settingsAlias="comp_title" /></title>

        <!-- Add to homescreen for Chrome on Android -->
        <meta name="mobile-web-app-capable" content="yes">
        <link rel="icon" sizes="196x196" href="<s:url value="/static/template/public/images/touch/chrome-touch-icon-196x196.png" />">

        <!-- Add to homescreen for Safari on iOS -->
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="Web Starter Kit">

        <!-- Tile icon for Win8 (144x144 + tile color) -->
        <meta name="msapplication-TileImage" content="<s:url value="/static/template/public/images/touch/ms-touch-icon-144x144-precomposed.png"/>">
        <meta name="msapplication-TileColor" content="#3372DF">

        <link rel="stylesheet" href="<s:url value="/static/template/public/styles/h5bp.css" />">
        <link rel="stylesheet" href="<s:url value="/static/template/public/styles/components/components.css" />">
        <link rel="stylesheet" href="<s:url value="/static/template/public/styles/main.css" />">
    </head>
  <body>

    <header class="app-bar promote-layer">
        <div class="app-bar-container">
            <button class="menu"><img src="<s:url value="/static/template/public/images/hamburger.svg" />" alt="Menu"></button>
            <h1 class="logo"><asu:settingStringValue settingsAlias="comp_title"/></h1>
            <section class="app-bar-actions">
            <!-- Put App Bar Buttons Here -->
            </section>
        </div>
    </header>

    <nav class="navdrawer-container promote-layer">
      <h4>Navigation</h4>
      <ul>
        <li><a href="#hello">Hello</a></li>
        <li><a href="#get-started">Get Started</a></li>
        <li><a href="styleguide/index.html">Style Guide</a></li>
      </ul>
    </nav>

    <main>
        <tiles:insertAttribute name="content"/>
      <h1 id="hello">Hello!</h1>
      <p>Welcome to Web Starter Kit.</p>

      <h2 id="get-started">Get Started.</h2>
      <p>Read how to <a href="http://developers.google.com/web/starter-kit">Get Started</a> or check out the <a href="styleguide/index.html">Style Guide</a>.</p>
    </main>

    <!-- build:js scripts/main.min.js -->
    <script src="<s:url value="/static/template/public/scripts/main.js" />"></script>
    <!-- endbuild -->
  </body>
</html>
