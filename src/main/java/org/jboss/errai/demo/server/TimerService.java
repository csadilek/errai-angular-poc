package org.jboss.errai.demo.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class TimerService {

  @Inject
  private Event<String> timeEvent;
  private ScheduledFuture<?> timer = null;
  
  @PostConstruct
  public void start() {
    timer = Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        timeEvent.fire(time);
        System.out.println("Firing time:" + time);
      }
    }, 0, 1, TimeUnit.SECONDS);
  }
  
  @PreDestroy
  public void stop() {
    if (timer != null)
      timer.cancel(true);
  }
  
  private void onStart(@Observes String s) {
    if ("start".equals(s)) {
      System.out.println("Starting timer");
    }
  }
  
}