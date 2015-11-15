java_import 'com.hoshi.rubotoprocessing2.ProcessingSketchActivity'
require 'forwardable'
require_relative './sketch'

class ProcessingSketchActivity
  import org.ruboto.Log
  include Sketch

  # unused
  # PROTECTED_FIELDS = [
  #   :surfaceReady,
  #   :surfaceChanged,
  #   :dmouseX,
  #   :dmouseY,
  #   :emouseX,
  #   :emouseY,
  #   :windowFocused,
  #   :viewFocused,
  #   :frameRateLastNanos,
  #   :frameRateTarget,
  #   :frameRatePeriod,
  #   :looping,
  #   :redraw,
  #   :paused,
  #   :exitCalled,
  # ]
  PUBLIC_FIELDS = [
    :g,
    :displayWidth,
    :displayHeight,
    #:pixels,       # delegate
    :width,
    :height,
    :mouseX,
    :mouseY,
    :pmouseX,
    :pmouseY,
    :key,
    :keyCode,
    :focused,
    :frameCount,
    :finished,
  ]
  DELEGATE_METHODS = [
    :size,
    :can_draw,
    :canDraw,
    :no_loop,
    :noLoop,
    :pixels,
    :pixels=,
    :load_pixels,
    :update_pixels,
    :smooth,
    :load_font,
    :load_image,
    :load_table,
    :load_xml,
    :load_strings,
    :load_shape,
    :load_bytes,
  ]

  ### helper methods >>> ###
  field_accessor :mousePressed => :field_mouse_pressed
  field_accessor :keyPressed   => :field_key_pressed

  def mouse_pressed?
    @ruboto_java_instance.field_mouse_pressed
  end

  def key_pressed?
    @ruboto_java_instance.field_key_pressed
  end

  def ruboto_log
    Log
  end
  ### <<< helper methods ###

  private

  def synchronize_variables
    PUBLIC_FIELDS.each do |field_name|
      self.send("#{field_name}=", @ruboto_java_instance.send(field_name))
    end
  end

  def check_sketch_method
    [
      :setup,
      :draw,
      :key_pressed,
      :key_released,
      :mouse_pressed,
      :mouse_released,
      :mouse_clicked,
      :mouse_dragged,
      :mouse_moved,
      :mouse_entered,
      :mouse_exited,
    ].each do |m|
      instance_variable_set("@available_#{m}", Sketch.instance_methods(false).include?(m))
    end
  end

  def _setup
    extend SingleForwardable
    def_delegators(:@ruboto_java_instance, *DELEGATE_METHODS)
    check_sketch_method
    synchronize_variables
    setup if @available_setup
  rescue => e
    Log.e "exception in ruby code `setup`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _draw
    synchronize_variables
    draw if @available_draw
  rescue => e
    Log.e "exception in ruby code `draw`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _key_pressed
    key_pressed if @available_key_pressed
  rescue => e
    Log.e "exception in ruby code `key_pressed`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _key_released
    key_released if @available_key_released
  rescue => e
    Log.e "exception in ruby code `key_released`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_pressed
    mouse_pressed if @available_mouse_pressed
  rescue => e
    Log.e "exception in ruby code `mouse_pressed`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_released
    mouse_released if @available_mouse_released
  rescue => e
    Log.e "exception in ruby code `mouse_released`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_clicked
    mouse_clicked if @available_mouse_clicked
  rescue => e
    Log.e "exception in ruby code `mouse_clicked`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_dragged
    mouse_dragged if @available_mouse_dragged
  rescue => e
    Log.e "exception in ruby code `mouse_dragged`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_moved
    mouse_moved if @available_mouse_moved
  rescue => e
    Log.e "exception in ruby code `mouse_moved`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_entered
    mouse_entered if @available_mouse_entered
  rescue => e
    Log.e "exception in ruby code `mouse_entered`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end

  def _mouse_exited
    mouse_exited if @available_mouse_exited
  rescue => e
    Log.e "exception in ruby code `mouse_exited`: #{e}"
    Log.e e.backtrace.join("\n")
    raise e
  end
end
