package org.houseofsoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  public static ApplicationContext get() {
    return applicationContext;
  }

  @Override
  public void setApplicationContext(@Nonnull ApplicationContext applicationContext) {
    ApplicationContextProvider.applicationContext = applicationContext;
  }

  public static <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }
}

