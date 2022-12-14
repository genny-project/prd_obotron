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
package life.genny.obotron.application;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Named;
import org.kie.kogito.process.Process;
import org.kie.kogito.addon.quarkus.messaging.common.QuarkusMessageConsumer;
import org.kie.kogito.event.EventReceiver;

@io.quarkus.runtime.Startup
public class CallProcessQuestionsGTMessageConsumer_11 extends QuarkusMessageConsumer<CallProcessQuestionsGTModel, life.genny.kogito.common.models.S2SData> {

    @Inject
    @Named("callProcessQuestionsGT")
    Process<CallProcessQuestionsGTModel> process;

    @Inject
    EventReceiver eventReceiver;

    private Set<String> correlation;

    @javax.annotation.PostConstruct
    void init() {
        init(process, "end_process_questions", life.genny.kogito.common.models.S2SData.class, eventReceiver, correlation);
    }

    private CallProcessQuestionsGTModel eventToModel(life.genny.kogito.common.models.S2SData event) {
        CallProcessQuestionsGTModel model = new CallProcessQuestionsGTModel();
        if (event != null) {
            model.setData(event);
        }
        return model;
    }
}
