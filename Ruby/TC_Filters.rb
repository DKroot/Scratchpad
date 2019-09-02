require 'test/unit' 
require 'watir'

class TC_Filters < Test::Unit::TestCase
  def setup
    puts "Launching Test for Filters in Incoming Faxes and Orders"
    @browser = Watir::Browser.new()
    @browser.goto("http://apps.proficienthealth.prv/")
    @incomming_department = "Mike K Incoming Fax"
    @phone_filter = "877-506-8443"
  end

  def teardown
    puts "Filter Testing has concluded"
    @browser.close
  end
  
  def assert_true(condition, message)
    assert condition, message
  end
  def no_test_orders_filters()
    puts "Testing Orders Filters"

    go_to_orders_list

    assert_true(@browser.title == "Order List", "I am not in Order List... Where am I?")

    records_a = get_record_count()

    sleep 1

    @browser.text_field(:name, "cb_orderNameFilter").click
    @browser.divs(:class, "z-east-body").each{ |div|
      if(div.table(:index=>0).exist? and div.table(:index=>0).table(:index=>0).exist? and div.table(:index=>0).table(:index=>0).table(:index=>0).exist?) then
        if(div.table(:index=>0).table(:index=>0).table(:index=>0).td(:text, "MAM - Mammography").exits?) then
          div.table(:index=>0).table(:index=>0).table(:index=>0).td(:text, "MAM - Mammography").click
        end
      end
    }

    @browser.image(:src, "/HCO/images/find.png").click

    sleep 3

  end

  def test_scheduling_filters()
    puts "Testing Scheduling Filters"

    go_to_scheduling

    assert_true(@browser.title == "Incoming Faxes", "I am not in Incoming Faxes... Where am I?")

    records_a = get_record_count()

    #puts records_a.to_s + " Records Found"

    puts "Filtering by {Sent From Number}"

    @browser.text_field(:name, "tx_NumberSentFrom").set(@phone_filter)

    apply_filters()

    sleep 1
    
    records_b = get_record_count()

    #puts "Filter resulted in " + records_b.to_s
    assert_true(records_a > records_b, "Failure: Number of Records after applying filter {Sent From Number} should be less than before applying the filters. Without Filter: " + records_a.to_s + " and got " + records_b.to_s + " after applying filter.")

    @browser.text_field(:name, "tx_NumberSentFrom").set("")

    apply_filters()

    records_b = get_record_count()

    assert_true(records_a == records_b, "Failure: Number of Records after filtering {Sent From Number} with an empy string '' should had resulted in the same number of records as without filters.")

    puts "Filtering by {From Name}"

    @browser.text_field(:name, "From Name").set("Macon")

    apply_filters()

    records_b = get_record_count()

    assert_true(records_a > records_b, "Failure: Number of Records after applying filter {Name} should be less than before applying the filters.")

    @browser.text_field(:name, "From Name").set("")
    
    apply_filters()

    records_b = get_record_count()

    assert_true(records_a == records_b, "Failure: Number of Records after filtering {Name} with an empy string '' should had resulted in the same number of records as without filters.")

    puts "Filtering by {Transaction ID}"

    @browser.text_field(:name, "tx_Transactionid").set("2779787146196987")

    apply_filters()

    records_b = get_record_count()

    assert_true(records_a > records_b, "Failure: Number of Records after applying filter {Transaction ID} should be less than before applying the filters.")

    @browser.text_field(:name, "tx_Transactionid").set("99999999999999")

    apply_filters()

    records_b = get_record_count()

    assert_true(records_b == 0, "Failure: Number of Records after applying filter {Transaction ID} should be 0.")

    @browser.text_field(:name, "tx_Transactionid").set("")

    apply_filters()

    records_b = get_record_count()

    assert_true(records_a == records_b, "Failure: Number of Records after filtering {Transaction ID} with an empy string '' should had resulted in the same number of records as without filters.")

    sleep 1

  end

  def get_record_count
    sleep 1
    return @browser.div(:class, "z-listbox-body").links(:text, "View").length
    #    @browser.divs(:class, "z-paging-info").each { |paging_info|
    #      if paging_info.text.include? "[" and paging_info.text.include? "/" and paging_info.text.include? "]" then
    #        return paging_info.text[paging_info.text.index('/')+1..paging_info.text.index(']')-1].strip.to_i
    #      end
    #    }
    #    return 0
  end

  def apply_filters()
    @browser.spans(:class, "z-button").each { |span|
      if(span.td(:text, "Apply Filter").exist?) then
        span.table(:index=>0).td(:text, "Apply Filter").click
      end
    }
  end

  def go_to_scheduling()
    go_to_orders_list
    # Verify that Scheduling is present
    assert_true(@browser.link(:text, @incomming_department).exist?, "Failure: I could not find the {Scheduling} link to click on.")
    puts "Opening Cardiology"
    @browser.link(:text, @incomming_department).click
    tries = 0
    until @browser.title == "Incoming Faxes" do
      sleep 0.5
      tries = tries + 1
      if (tries > 3) then
        break
      end
    end
    # Verify that the browser has Proficient Orders open.
    assert_true(@browser.title == "Incoming Faxes", "Failure: It seems I am not in Incoming Faxes, where I should be.")
  end

  def go_to_orders_list()
    puts "Opening Orders List..."
    # Call Login to go to the login page an enter the default user/password to get started
    login
    # Wait a small bit to assert button existence
    sleep 1
    # Assert that the button to go to Proficient Orders is present
    assert_true(@browser.span(:text, "Proficient Orders").exist?, "Failure: Cannot find the {Proficient Orders} Button.")
    puts "Opening Proficient Orders"
    @browser.span(:text, "Proficient Orders").click
    tries = 0
    until @browser.title == "Order List" do
      sleep 0.5
      tries = tries + 1
      if (tries > 3) then
        break
      end
    end
    # Verify that the browser has Proficient Orders open.
    if(@browser.title != "Order List") then
      # Verify that Scheduling is present
      assert_true(@browser.link(:text, "Orders").exist?, "Failure: I could not find the {Orders} link to click on.")
      @browser.link(:text, "Scheduling").click
      tries = 0
      until @browser.title == "Incoming Faxes" do
        sleep 0.5
        tries = tries + 1
        if (tries > 3) then
          break
        end
      end
    end

    # Verify that the browser has Proficient Orders open.
    assert_true(@browser.title == "Order List", "Failure: It seems I am not in Order List, where I should be.")
  end
  def go_orders_list()
    puts "Opening Scheduling..."
    # Call Login to go to the login page an enter the default user/password to get started
    login
    # Wait a small bit to assert button existence
    sleep 0.5
    # Assert that the button to go to Proficient Orders is present
    assert_true(@browser.span(:text, "Proficient Orders").exist?, "Failure: Cannot find the {Proficient Orders} Button.")
    puts "Opening Proficient Orders"
    @browser.span(:text, "Proficient Orders").click
    tries = 0
    until @browser.title == "Order List" do
      sleep 0.5
      tries = tries + 1
      if (tries > 3) then
        break
      end
    end
    sleep 1
    # Verify that the browser has Proficient Orders open.
    assert_true(@browser.title == "Order List", "Failure: It seems I am not in Proficient Orders, where I should be.")
  end
  def login()
    sleep 1
    puts "Typing Login Credentials"
    # Verify that Proficient Health web application has been loaded and not some other page
    assert_equal("Proficient Health Application Login", @browser.title, "Failure: Browser Title should be {Proficient Health Application Login}. Am I some place else?")
    # Verify Credential Fields creation
    #    assert_equal(@browser.text_field(:id, "orgkey").exist?, "Failure: Credential Field {Organization Key} could not be found.")
    #    assert_equal(@browser.text_field(:id, "username").exist?, "Failure: Credential Field {Username} could not be found.")
    #    assert_equal(@browser.text_field(:id, "password").exist?, "Failure: Credential Field {Password} could not be found.")

    # Insert Credentials
    @browser.text_field(:id, "orgkey").set("phealth")
    @browser.text_field(:id, "username").set("ezequiel")
    @browser.text_field(:id, "password").set("incorrect_password")
    # Verify credentials
    assert_equal("phealth", @browser.text_field(:id, "orgkey").value, "CMC not set")
    assert_equal("ezequiel", @browser.text_field(:id, "username").value, "username not set")
    assert_equal("incorrect_password", @browser.text_field(:id, "password").value, "Password not Pampas?")

    assert_true(@browser.div(:text, "Login").exist?, "Some how I manage to login with a wrong password!!")


    @browser.text_field(:id, "password").set("pampas")


    @browser.div(:text, "Login").click

    tries = 0
    until @browser.div(:text, "Back").exist? do
      sleep 0.5
      tries = tries + 1
      if (tries > 3) then
        break
      end
    end
    assert_true(@browser.div(:text, "Back").exist?, "Did I Login or Not?")

  end
end