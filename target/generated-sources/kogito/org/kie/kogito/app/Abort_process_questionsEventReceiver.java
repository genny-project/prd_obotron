/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.app;

import java.util.concurrent.CompletionStage;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.kie.kogito.addon.quarkus.messaging.common.AbstractQuarkusCloudEventReceiver;
import org.kie.kogito.event.CloudEventUnmarshallerFactory;
import org.kie.kogito.event.EventUnmarshaller;
import io.quarkus.runtime.Startup;

@Startup
@ApplicationScoped
public class Abort_process_questionsEventReceiver extends AbstractQuarkusCloudEventReceiver<String> {

    @Inject
    EventUnmarshaller<String> eventDataUnmarshaller;

    @Inject
    CloudEventUnmarshallerFactory<String> cloudEventUnmarshaller;

    @Incoming("abort_process_questions")
    public CompletionStage<?> onEvent(Message<String> message) {
        return produce(message);
    }

    @PostConstruct
    void init() {
        init(eventDataUnmarshaller, cloudEventUnmarshaller);
    }
}
