---
typora-copy-images-to: pic

---

bean解析：默认标签元素 or  字定义标签元素

~~~java
    protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
        if (delegate.isDefaultNamespace(root)) {
            NodeList nl = root.getChildNodes();

            for(int i = 0; i < nl.getLength(); ++i) {
                Node node = nl.item(i);
                if (node instanceof Element) {
                    Element ele = (Element)node;
                    if (delegate.isDefaultNamespace(ele)) {
                        //解析默认标签元素
                        this.parseDefaultElement(ele, delegate);
                    } else {
                        //解析自定义标签元素
                        delegate.parseCustomElement(ele);
                    }
                }
            }
        } else {
            delegate.parseCustomElement(root);
        }

    }
~~~

**parseDefaultElement** 解析四种默认标签：import、alias、bean、beans

~~~java
private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
        if (delegate.nodeNameEquals(ele, "import")) {
            this.importBeanDefinitionResource(ele);
        } else if (delegate.nodeNameEquals(ele, "alias")) {
            this.processAliasRegistration(ele);
        } else if (delegate.nodeNameEquals(ele, "bean")) {
            this.processBeanDefinition(ele, delegate);
        } else if (delegate.nodeNameEquals(ele, "beans")) {
            this.doRegisterBeanDefinitions(ele);
        }

    }
~~~

**processBeanDefinition(ele, delegate)** 

```java
protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {    
    //委托BeanDefinitionParserDelegate类进行元素解析返回bdHolder
    BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);    
    if (bdHolder != null) {
        //bdHolder不为空表示还有自定义属性，还需再解析自定义标签
        bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder); 
        try {        
 //委托BeanDefinitionReaderUtils注册bean
        BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, this.getReaderContext().getRegistry());            
            } catch (BeanDefinitionStoreException var5) { 
            this.getReaderContext().error("Failed to register bean definition with name '" + bdHolder.getBeanName() + "'", ele, var5);        
        } 
 	//发出响应事件通知监听器这个bean已经加载完成  
     this.getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));        
    }}
```

