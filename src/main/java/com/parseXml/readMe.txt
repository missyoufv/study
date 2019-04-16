xml是一种通用的数据交换格式，他的平台无关性，语言无关性，系统无关性，给数据集成与交换带来了极大的方便，xml在不同的语言环境中解析方式都是一样，
    只不过实现的语法不同而已。

xml的解析方式分为四种；1.DOM解析；2.SAX解析；3.JDOM解析；4.DOM4J解析。其中前两种属于基础方法，是官方提供的平台无关的解析方法；后两种属于扩展方法，
    他们是在基础的方法上扩展出来的，只使用于java平台。


DOM解析(Java自身原生的两种解析XML方式之一——DOM方法)

 原理是：首先在内存中创建一个Document对象，然后把XML文档读取进来赋值给这个dom对象。由于dom对象是基于树结构的，
 所以对dom对象进行遍历即可。对内存中的dom对象可以进行查询、修改、删除操作，还可以写回原XML文档保存修改。

   优点：
    a、由于整棵树在内存中，因此可以对xml文档随机访问
    b、可以对xml文档进行修改操作
   缺点：
    a、整个文档必须一次性解析完
    a、由于整个文档都需要载入内存，对于大文档成本高


2.SAX解析

SAX的全称是Simple APIs for XML，即xml简单应用程序接口。与DOM不同，SAX提供的访问模式是一种顺序模式，这是一种快速读写xml数据的方式。
    当使用SAX分析器对xml文档进行解析时，会触发一系列事件并激活相应的事件处理函数，应用程序通过对这些事件处理函数实现对xml文档的访问，
    因此SAX接口也被称作事件驱动接口。


优点：
（1）采用事件驱动模式，对内存耗费比较小
（2）适用于只处理xml文件中的数据时
缺点：
（1）编码比较麻烦
（2）很难同时访问xml文件中的多处不同数据


操作步骤：

1：创建解析工厂：SAXParserFactory factory = SAXParserFactory.newInstance();

2：由工厂创建解析器：SAXParser parser = factory.newSAXParser();

3：通过解析器的parse()方法，对指定xml文档以指定handler之类进行解析查询：parser.parse(xmlFile, new MySaxListener())；



我们要继承DefaultHandler类，定义相应的查询操作类：

   1：重写父类中的文档开始方法、文档结束方法，定义开始、结束遍历xml文档时的操作：

     void startDocument() 接收文档开始的通知。

     void endDocument() 接收文档结束的通知。

   2：重写父类的标签开始方法、标签结束方法，定义遍历到一个开始、结束标签时的操作：

     void startElement(String uri, String localName, String qName, Attributes attributes) //参数qName是标签名、attributes是属性列表 接收元素开始的通知。

     void endElement(String uri, String localName, String qName) 接收元素结束的通知。

    3：重写characters(char[] ch, int start, int length)方法：

    // 对事件发生时，元素的字符怎么处理
    public void characters(char[] ch, int start, int length) throws SAXException {
        //参数ch是当上述4中事件随便一个发生时，对应的元素的值，值在ch中start开始，length长。从头到尾遍历整个xml文档时，每个标签的值依次被存入ch中。

 }


也就是说，通过SAX解析xml文档是没有dom对象出现的，所以不会有node，不会有getNodeName()、getNodeValue()获取结点名、值。
总结：SAX解析XML文档的结点名是通过事件函数的参数qName获取的，属性是通过参数attributes的getValue("属性名")获取的，
结点值是通过当前事件函数发生时，characters(char[] ch, int start, int length)方法中的内容获取的。


 三：JDOM方法

   JDOM方法是根据DOM方法的众多繁琐操作进行包装得到的，上面我们看到，DOM方法解析XML文档其实是很繁琐的，而且很混乱，标签、属性、
   换行空格都当作结点类型来处理。JDOM方法定义了一系列通俗、好记的方法来解析XML，方法的底层封装了一系列DOM操作，但是我们不必亲
   自去进行这些繁琐的工作了。

 优点：

    a、DOM方式的优点:查找方便，可以修改
 缺点
    a、DOM方式的缺点:装载整个文档,对内存容量要求高

  在JDOM中，同一了根节点、普通结点、属性等全为Element类型。

   操作步骤：

   1：创建一个SAXbuilder：SAXBuilder builder = new SAXBuilder();

    2：创建文件输入流打开xml文件：InputStream in = new FileInputStream("XXX.xml");

   3：通过builder，从输入流读取xml文件创建dom对象：Document dom = builder.build(in);

   4：获取根节点：Element root=dom.getRootElement();

   5：获取子节点列表：List<Element> childNodes = node.getChildren();

   6：遍历子节点列表，获取第i个结点：Element node = childNodes.get(i);

   7：读取结点信息：

     1）结点属性值：node.getAttributeValue("属性名")；

     2）结点名：node.getName()；

     3）结点值：node.getValue();

     4）子结点文本值：node.getChildText("子结点名")；


四：DOM4J方法

    Dom4j是目前最流行、最好用的XML解析工具，解析XML的速度最快。

    操作步骤：

    1：创建SAXReader：SAXReader reader = new SAXReader();

    2：创建文件输入流打开xml文件：InputStream in = new FileInputStream("XXX.xml");

    3：通过reader和输入流读取xml文件到内存创建Document对象：Document dom = reader.read(in);

    4：获取根节点：Element root=dom.getRootElement();

    5：获取子节点列表：List<Element> childNodes = root.elements();

    6：遍历子节点：Element node = childNodes.get(i);

    7：读取结点信息：

     1）结点属性值：node.attributeValue("属性名")；

     2）结点名：node.getName()；

     3）结点值：node.getValue();

     4）子结点文本值：node.elementText("子结点名")



总结：

1）DOM、JDOM、DOM4j都是把xml文档读取到内存中，生成dom对象进行遍历的；

     DOM是Java原生的，所以比较繁琐；

     JDOM是对DOM操作的封装，更加通俗、易记，操作也快了一点；

     DOM4j解析xml的函数上与JDOM差不多，只不过有几个相同功能的函数名字不同而已，过程都是一样的；但由于底层使用了Xpath等方法加快了索引，
     所以检索性能更快。

2）SAX是基于事件驱动的，查询事件监听器继承自DefaultHandler，定义了检索xml过程中遇到开始标签、结束标签时执行的事件函数，从而查找需要的
    信息并返回而不是把整个文档都加载进来。