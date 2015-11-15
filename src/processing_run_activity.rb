require 'ruboto/widget'
require 'ruboto/util/toast'

ruboto_import_widgets :Button, :LinearLayout, :TextView

require 'processing_sketch_activity'

class ProcessingRunActivity
  def onCreate(bundle)
    super

    opts = {
      java_class:  ProcessingSketchActivity,
      script:      "processing_sketch_activity",
    }
    start_ruboto_activity(opts)

  rescue Exception
    Log.e "Exception creating activity: #{$!}"
    Log.e $!.backtrace.join("\n")
  end
end
