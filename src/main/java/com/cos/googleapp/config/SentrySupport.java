package com.cos.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;


@Configuration
public class SentrySupport {

	public SentrySupport() {
		System.out.println("============================================= SentrySupport.init()");
		// 아래 Client Keys DSN값은 sentry.io에서 다시 가져올 것.
		// DSN 값은 나중에는 application.yml에 옮겨야 한다고
		Sentry.init("DSN 키");
	}

    public void logSimpleMessage(String msg) {
        // This sends an event to Sentry.
        EventBuilder eventBuilder = new EventBuilder()
                        .withMessage(msg)
                        .withLevel(Event.Level.ERROR)
                        .withLogger(SentrySupport.class.getName());

        // Note that the *unbuilt* EventBuilder instance is passed in so that
        // EventBuilderHelpers are run to add extra information to your event.
        Sentry.capture(eventBuilder);
    }

}
