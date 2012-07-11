package bos_in_grails

import javax.security.auth.login.LoginContext
import org.ow2.bonita.util.SimpleCallbackHandler
import org.ow2.bonita.util.AccessorUtil
import org.ow2.bonita.facade.QueryDefinitionAPI

class ProcessController {

    def index() { redirect(action: 'list_processes') }

    def list_processes() {
        def callbackHandler = new SimpleCallbackHandler('Guest', '')
        LoginContext loginContext = new LoginContext('BonitaStore', callbackHandler)
        loginContext.login()

        QueryDefinitionAPI queryDefinitionAPI = AccessorUtil.getQueryDefinitionAPI()
        def processList = queryDefinitionAPI.getLightProcesses()*.getUUID()

        loginContext.logout()

        [processList: processList]
    }
}
