require 'watir'
#require 'watir/element_collections'

Watir::IE # to trigger autoload
#Watir::IE.class_eval do
#end

Watir::ElementCollections.class_eval do
  def new_method
  end
end