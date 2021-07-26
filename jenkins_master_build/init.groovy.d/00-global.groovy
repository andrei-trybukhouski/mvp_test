#!groovy

import jenkins.model.*
import hudson.util.*;
import jenkins.install.*;
import org.jenkinsci.plugins.*
import hudson.security.csrf.DefaultCrumbIssuer
import hudson.security.*
import jenkins.model.JenkinsLocationConfiguration

def instance = Jenkins.getInstance()
def addr = InetAddress.getLocalHost().getHostAddress();

JenkinsLocationConfiguration location = Jenkins.instance.getExtensionList('jenkins.model.JenkinsLocationConfiguration')[0]
location.url = 'https://' + addr + ':8080/'
location.save()

instance.setNumExecutors(0)
instance.setCrumbIssuer(new DefaultCrumbIssuer(true))
instance.setNoUsageStatistics(true)
instance.save()

println "--> creating local user 'admin'"
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin','admin')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)

instance.save()

