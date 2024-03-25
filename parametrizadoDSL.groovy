job('ejemplo2-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      		git('https://github.com/sergiosuarezv/job.parametriado.mio.git', 'main') { node ->
        		node / gitConfigName('sergiosuarezv')
        		node / gitConfigEmail('sergiosuarez.v@gmail.com')
      		}
    	} 
  	parameters {
   		stringParam('nombre', defaultValue = 'Sergio', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  	triggers {
    		cron('H/7 * * * *')
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}
  	publishers {
      		mailer('sergiosuarez.v@gmail.com', true, true)

    	}
}
