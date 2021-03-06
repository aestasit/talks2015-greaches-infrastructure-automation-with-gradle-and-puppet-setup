


database {
  jdbc {
    db = 'petclinic'
    password = 'petclinic'
    user = 'petclinic'
  }
}




environments {

  vagrant {

    sshUser = 'vagrant'
    sshPassword = 'vagrant'
    sshPasswordLogin = true

    database {
      jdbc {
        db = 'petclinic'
        password = 'petclinic'
        user = 'petclinic'
      }
    }

    deployment {
      tomcatSourceUrl = 'http://192.168.48.30/apache-tomcat-8.0.18.tar.gz'
      appLocation     = 'http://192.168.48.30/petclinic-0.1-SNAPSHOT.war'
      appVHost        = 'local.petclinic.greach.es'
    }

    servers = [
      '192.168.48.30' : [
        roles: [ 'repository' ]            
      ],
      '192.168.48.20' : [
        roles: [ 'database' ]            
      ],
      '192.168.48.10' : [
        roles: [ 'application' ]         
      ],
    ]

  }

  aws {

    sshUser = 'ubuntu'
    sshKeyFile = 'production.pem'

    database {
      jdbc {
        db = 'petclinic'
        password = 'petclinic'
        user = 'petclinic'
      }
    }

    deployment {
      tomcatSourceUrl = 'https://archive.apache.org/dist/tomcat/tomcat-8/v8.0.18/bin/apache-tomcat-8.0.18.tar.gz'
      appLocation     = 'https://oss.sonatype.org/content/repositories/snapshots/com/aestasit/workshops/org/springframework/samples/petclinic/0.1-SNAPSHOT/petclinic-0.1-20150201.232449-1.war'
      appVHost        = 'production.petclinic.greach.es'
    }
     
    servers = [
      '54.216.8.184' : [
        roles: [ 'database' ]      
      ],
      '54.73.68.185' : [
        roles: [ 'application' ] 
      ],
    ]

  }

}


