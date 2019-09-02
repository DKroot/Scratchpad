require 'rspec/expectations'
require 'logger'

@@log = Logger.new(STDOUT)
old_verbose, $VERBOSE = $VERBOSE, nil # suppress a warning
# Arguments to format: 1. SeverityID, 2. DateTime, 3. pid, 4.SeverityLabel, 5.ProgName, 6. Message
Logger::Formatter::Format = "[%4$-5s %2$s] %6$s\n"
$VERBOSE = old_verbose
@@log.datetime_format = "%H:%M:%S"

case RUBY_PLATFORM
  when /darwin|win32|mingw/ # Mac or Windows
    case ENV["BROWSER"]
      when 'IE' # Windows only
        # Using WebDriver 0.1.8 not working with IE 8:
        # Unable to get browser (Selenium::WebDriver::Error::NoSuchDriverError)
#        require 'selenium-webdriver'
#        require 'watir-webdriver'
#        driver = Selenium::WebDriver.for :ie
#        browser = Watir::Browser.new(driver)
##        browser = Watir::Browser.new(:ie)

        require 'watir'

        # == "Monkey patch" Watir for better compatibility with Watir-WebDriver ==

        require 'watir/element_collections'
        Watir::ElementCollections.class_eval do
          alias_method :original_array_op, :[]

          # Zero-based array operator
          def [](n)
            return original_array_op(n+1)
          end
        end

        require 'watir/container'
        require 'watir/element'
        require 'watir/table'
        Watir::TableRow.class_eval do
          alias_method :original_array_op, :[]

          # Zero-based array operator
          def [](n)
            return original_array_op(n+1)
          end
        end

        # Close all previously open IE RAP windows
        while (true)
          begin
            browser = Watir::IE.attach(:title, /.* - RAP/)
            browser.close
          rescue Watir::Exception::NoMatchingWindowFoundException
            break
          end
        end

        browser = Watir::IE.new_window
        ##Watir::Browser.default = 'ie'
        ##browser = Watir::Browser.new
        ###browser = Watir::IE.new_process # Not working with IE 7, non-admin
        browser.speed = :fast
      when 'Chrome'
        require 'watir-webdriver'

        browser = Watir::Browser.new(:chrome)
      when 'Safari'
        #TBD Is SafariWatir usable?
        require 'watir'

        browser = Watir::Safari.new
      else #"Fx"
        require 'watir-webdriver'

        browser = Watir::Browser.new(:firefox)
    end

  when /java/ #JRuby?
    require 'celerity'
    browser = Celerity::Browser #TBD Does it work?

  else
    raise "This platform (#{RUBY_PLATFORM}) is not supported"
end