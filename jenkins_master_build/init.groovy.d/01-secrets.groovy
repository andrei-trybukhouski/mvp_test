import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.CredentialsScope
import jenkins.model.Jenkins
import com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey

/* groovylint-disable-next-line CompileStatic */
println '--> creating ssh keys for agent'
def domain = Domain.global()
def store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

String keyfile = '/home/jenkins/id_ssh_agent'
def privateKey = new BasicSSHUserPrivateKey(
        CredentialsScope.GLOBAL,
        'agent_ssh_key',
        'jenkins',
        new BasicSSHUserPrivateKey.FileOnMasterPrivateKeySource(keyfile),
        '',
        'key for agent'
)
store.addCredentials(domain, privateKey)

println 'creating ssh keys for agent <--'
