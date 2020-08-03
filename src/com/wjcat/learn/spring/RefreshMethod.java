//package com.wjcat.learn.spring;
//
///**
// * @author yupeijiang
// * @date 2020/7/28 0028
// */
//public class RefreshMethod {
//
//    public void refresh() throws BeansException, IllegalStateException {
//        synchronized (this.startupShutdownMonitor) {
//            // Prepare this context for refreshing.
//            // 准备更新上下文，设置开始时间，标记活动标志，初始化配置文件中的占位符
//            prepareRefresh();
//
//            // Tell the subclass to refresh the internal bean factory.
//            // 一、 web工程 AbstractRefreshableApplicationContext
//            // 将 bean 定义加载到给定的 BeanFactory 中
//            // 1. createBeanFactory(); 为此上下文创建内部 BeanFactory
//            // 2. customizeBeanFactory(beanFactory); 定制 BeanFactory，是否允许 BeanDefinition 覆盖、是否允许循环引用
//            // 3. loadBeanDefinitions(beanFactory); 通过 BeanDefinitionReader 解析 xml 文件，解析封装信息到 BeanDefinition，并将其 register 到 BeanFactory 中
//            // 以 beanName为key将beanDefinition 存到 DefaultListableBeanFactory#beanDefinitionMap 中
//            // 二、 SpringBoot GenericApplicationContext，实际 register 过程在 invokeBeanFactoryPostProcessors 中
//            ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
//
//            // Prepare the bean factory for use in this context.
//            // 准备 BeanFactory 以便在此上下文中使用。
//            // 1. 设置 BeanFactory 的类加载器
//            // 2. 添加几个 BeanPostProcessor，
//            // 3. 实例化几个特殊的 bean
//            prepareBeanFactory(beanFactory);
//
//            try {
//                // Allows post-processing of the bean factory in context subclasses.
//                // 在 AbstractApplicationContext#postProcessBeanFactory 为空实现，留给子类做扩展，不同 ApplicationContext 实现不同，不作详细描述
//                postProcessBeanFactory(beanFactory);
//
//                // Invoke factory processors registered as beans in the context.
//                // Spring 的 SPI
//                // 先调用 BeanDefinitionRegistryPostProcessor 和 ImportBeanDefinitionRegistrar 的实现类
//                // 再调用 BeanFactoryPostProcessor 各个实现类的 postProcessBeanFactory(factory) 方法
//                // 例如：ConfigurationClassPostProcessor 会扫描 <context:component-scan/> 和 @SpringBootApplication(scanBasePackages = "") 中的Component，并且将 @Configuration 类中的 @Bean register 到 BeanFactory 中
//                // 扩展例如：MyBatis MapperScannerConfigurer 和 MapperScannerRegistrar，扫描Mapper register 到 BeanFactory 中
//                invokeBeanFactoryPostProcessors(beanFactory);
//
//                // Register bean processors that intercept bean creation.
//                // 注册 BeanPostProcessor 的实现类，不同于刚刚的 BeanFactoryPostProcessor
//                // BeanPostProcessor 接口两个方法 postProcessBeforeInitialization 和 postProcessAfterInitialization 会在 Bean 初始化之前和之后调用
//                // 这边 Bean 还没初始化，下面的 finishBeanFactoryInitialization 才是真正的初始化方法
//                registerBeanPostProcessors(beanFactory);
//
//                // Initialize message source for this context.
//                // 初始化当前 ApplicationContext 的 MessageSource，解析消息的策略接口，用于支持消息的国际化和参数化
//                // Spring 两个开箱即用的实现 ResourceBundleMessageSource 和 ReloadableResourceBundleMessageSource
//                initMessageSource();
//
//                // Initialize event multicaster for this context.
//                // 初始化当前 ApplicationContext 的事件广播器
//                initApplicationEventMulticaster();
//
//                // Initialize other special beans in specific context subclasses.
//                // 典型模板方法
//                // 子类可以在实例化 bean 之前，做一些初始化工作，SpringBoot 会在这边启动 Web 服务
//                onRefresh();
//
//                // Check for listener beans and register them.
//                // 向 initApplicationEventMulticaster() 初始化的 applicationEventMulticaster 注册事件监听器，就是实现 ApplicationListener 接口类
//                // 观察者模式，例如实现了 ApplicationEvent，通过 ApplicationEventPublisher#publishEvent()，可以通知到各个 ApplicationListener#onApplicationEvent
//                registerListeners();
//
//                // Instantiate all remaining (non-lazy-init) singletons.
//                // 初始化所有的 singletons bean（lazy-init 的除外）
//                // Spring bean 初始化核心方法
//                finishBeanFactoryInitialization(beanFactory);
//
//                // Last step: publish corresponding event.
//                // ApplicationEventPublisher#publishEvent() 初始化完成（ContextRefreshedEvent）事件
//                finishRefresh();
//            }
//
//            catch (BeansException ex) {
//                if (logger.isWarnEnabled()) {
//                    logger.warn("Exception encountered during context initialization - " +
//                            "cancelling refresh attempt: " + ex);
//                }
//
//                // Destroy already created singletons to avoid dangling resources.
//                // destroy 已经创建的 singleton 避免占用资源
//                destroyBeans();
//
//                // Reset 'active' flag.
//                // 重置'有效'标志
//                cancelRefresh(ex);
//
//                // Propagate exception to caller.
//                throw ex;
//            }
//
//            finally {
//                // Reset common introspection caches in Spring's core, since we
//                // might not ever need metadata for singleton beans anymore...
//                // 重置Spring核心中的常见内省缓存，因为可能不再需要单例bean的元数据了...
//                resetCommonCaches();
//            }
//        }
//    }
//
//}
