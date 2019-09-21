package cn.mingyang.web.w04_response;

/**
 *  响应消息：服务器端发送给客户端的数据
 *      数据格式：
 *          1.响应行
 *              1.1.组成：协议/版本  响应状态码  状态码描述
 *              1.2.响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态。
 *                  1.状态码都是3位数字
 *                  2.分类：
 *                      1xx：服务器就收客户端信息，但没有接受完成，等待一段时候后，发送1xx多状态码。
 *                      2xx：成功  代表：200。
 *                      3xx：重定向。代表：302（重定向），304（访问缓存）。
 *                      4xx：客户端错误。
 *                          代表：
 *                              404（请求路径没有对应的资源）
 *                              405（请求方式没有对应的doXxx方法）
 *                      5xx：服务器端错误。代表：500（服务器内部出现异常）
 *
 *          2.响应头
 *              1.格式：头名称：值
 *              2.常见的响应头：
 *                  1.Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式。
 *                  2.Content-disposition：服务器告诉客户端以什么格式打开响应体数据。
 *                      值：
 *                          in-line：默认值，在当前页面内打开。
 *                          attachment;filename=xxx：服务器告诉客户端以什么格式打开响应体数据。
 *
 *          3.响应空行
 *          4.响应体：传输的数据
 *
 * 响应字符串格式：
 * HTTP/1.1 200
 * Set-Cookie: JSESSIONID=3F1A82A22CC4A33FA561EE8968BDD31F; Path=/; HttpOnly
 * Content-Type: text/html;charset=UTF-8
 * Content-Length: 220
 * Date: Sat, 21 Sep 2019 01:56:03 GMT
 *
 * <html>
 *   <head>
 *     <title>欢迎来到我的页面</title>
 *   </head>
 *   <body>
 *   <form action="/demo5" method="post">
 *     <input name="userName" />
 *     <input type="submit" value="提交"/>
 *   </form>
 *   </body>
 * </html>
 *
 *
 */
public class Demo01_response {
}
