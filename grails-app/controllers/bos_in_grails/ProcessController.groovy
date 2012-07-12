package bos_in_grails

import javax.security.auth.login.LoginContext
import org.ow2.bonita.util.SimpleCallbackHandler
import org.ow2.bonita.util.AccessorUtil
import org.ow2.bonita.facade.QueryDefinitionAPI
import org.ow2.bonita.facade.RuntimeAPI
import org.ow2.bonita.facade.uuid.ProcessDefinitionUUID

class ProcessController {

    def index() { redirect(action: 'list_processes') }

    def list_processes() {
        def callbackHandler = new SimpleCallbackHandler('admin', '')
        LoginContext loginContext = new LoginContext('BonitaStore', callbackHandler)
        loginContext.login()

        QueryDefinitionAPI queryDefinitionAPI = AccessorUtil.getQueryDefinitionAPI()
        def processList = queryDefinitionAPI.getLightProcesses()*.getUUID()

        loginContext.logout()

        [processList: processList]
    }

    def start_Buy_A_Mini() {
        [processUUID: params.process]
    }

    def instantiate_process() {
        def callbackHandler = new SimpleCallbackHandler('admin', '')
        LoginContext loginContext = new LoginContext('BonitaStore', callbackHandler)
        loginContext.login()

        RuntimeAPI runtimeAPI = AccessorUtil.getRuntimeAPI()
        def processUUID = new ProcessDefinitionUUID(params.processDefinitionUUID)
        Map<String, Object> parameters = new HashMap()
        parameters.put('car', params.car)
        runtimeAPI.instantiateProcess(processUUID, parameters)

        loginContext.logout()

        redirect(action: 'list_processes')
    }
}
