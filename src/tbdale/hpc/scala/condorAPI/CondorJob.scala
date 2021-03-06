package tbdale.hpc.scala.condorAPI

/*
 * CondorJob - data structure for HTCondor job parameters
 */
class CondorJob( val reqRam:String,
                 val executable:String,
                 val execArguments:String,
                 val universe:String,                 
                 val initialDir:String,
                 val outFileFQP:String,
                 val errFileFQP:String,
                 val condorLogFQP:String = ""){
  def genDescription:String={
    // generate condor submit description to pass to condor_submit via STDIN
"""
Executable     = %s
Arguments      = %s    
Universe       = %s                                                    
Image_Size = %s
initialdir = %s
error   = %s                                                
output  = %s                                                
log     = %s
log_xml = true
queue
""".format(executable,execArguments,universe,reqRam,initialDir,errFileFQP,outFileFQP,condorLogFQP )
  }
}