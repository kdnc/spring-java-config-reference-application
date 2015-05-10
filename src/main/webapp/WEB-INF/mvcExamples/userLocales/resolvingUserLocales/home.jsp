<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rest Examples</title>
</head>
<body>

    <h2>Resolving User Locales</h2>

    <a href="#spring-api/spring-mvc/user-locales/resolving-user-locales/example?language=en_US">en_US example</a><br />
    <a href="#spring-api/spring-mvc/user-locales/resolving-user-locales/example?language=de">de example</a>

    <p>In a Spring MVC application, a user’s locale is identified by a locale resolver, which has to implement the
        LocaleResolver interface.</p>
    <p>You can define a locale resolver by registering a bean of type LocaleResolver in the web application context. You
        must set the bean name of the locale resolver to localeResolver for DispatcherServlet to auto-detect. Note that you
        can register only one locale resolver per DispatcherServlet.</p>

    <h4>Resolving Locales by an HTTP Request Header</h4>

    <p>The default locale resolver used by Spring is AcceptHeaderLocaleResolver. It resolves locales by inspecting the
        accept-language header of an HTTP request. This header is set by a user’s web browser according to the locale
        setting of the underlying operating system. Note that this locale resolver cannot change a user’s locale because it is
        unable to modify the locale setting of the user’s operating system.</p>

    <h4>Resolving Locales by a Session Attribute</h4>

    <p>Another option of resolving locales is by SessionLocaleResolver. It resolves locales by inspecting a predefined
        attribute in a user’s session. If the session attribute doesn’t exist, this locale resolver determines the default locale
        from the accept-language HTTP header.</p>
    <p>You can set the defaultLocale property for this resolver in case the session attribute doesn’t exist. Note that this
        locale resolver is able to change a user’s locale by altering the session attribute that stores the locale.</p>


    <h4>Resolving Locales by a Cookie</h4>

    <p>You can also use CookieLocaleResolver to resolve locales by inspecting a cookie in a user’s browser. If the cookie
        doesn’t exist, this locale resolver determines the default locale from the accept-language HTTP header.</p>
    <p>The cookie used by this locale resolver can be customized by setting the cookieName and cookieMaxAge
        properties. The cookieMaxAge property indicates how many seconds this cookie should be persisted. The value -1
        indicates that this cookie will be invalid after the browser is closed.</p>
    <p>You can also set the defaultLocale property for this resolver in case the cookie doesn’t exist in a user’s browser.
        This locale resolver is able to change a user’s locale by altering the cookie that stores the locale.</p>

    <h4>Changing a User’s Locale</h4>
    <p>In addition to changing a user’s locale by calling LocaleResolver.setLocale() explicitly, you can also apply
        LocaleChangeInterceptor to your handler mappings. This interceptor detects if a special parameter is present in
        the current HTTP request.</p>

    <h4>Externalizing Locale-Sensitive Text Messages</h4>
    <p>Spring is able to resolve text messages for you by
    using a message source, which has to implement the MessageSource interface. Then your JSP files can use the
    <pre><spring:message></pre> tag, defined in Spring’s tag library, to resolve a message given the code.</p>


</body>
</html>
