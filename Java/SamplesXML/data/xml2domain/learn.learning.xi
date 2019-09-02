<?xml version="1.0" standalone="yes"?>
<fp:XI xmlns:fp="http://functionpro.com/xi" version="1.05">
  <fp:domain name="learn/learning" version="1.0.000">
    <fp:header>
      <fp:alias id="fp" name="Base"/>
      <fp:alias id="res" name="learn/Reservation"/>
    </fp:header>
    <!-- *** TYPES ***************************************************************  -->
    <fp:artifacts>
      <fp:event name="NoSeatsAvailable" id="NoSeatsAvailable"/>
      <fp:event name="AccessDenied" id="AccessDenied"/>
      <fp:event name="InvalidTimimg" id="InvalidTimimg"/>
      <fp:event name="InvalidStatus" id="InvalidStatus"/>
      <fp:event name="NeedToCancel" id="NeedToCancel"/>
      <fp:event name="EventHasBeenCancelled" id="EventHasBeenCancelled"/>

      <!-- +++ empty document ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:document name="Event1" id="learn/learning:Event1"/>

      <!-- +++ document ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:document name="EnrollmentRequest" id="learn/learning:EnrollmentRequest">
        <fp:attribute name="cool">
          <body>
            <text id="1">This is an attribute. Any simple XML will do.</text>
          </body>
        </fp:attribute>
        <fp:field name="Complex" type="EventSchedule">
          <fp:field name="One" domain="fp" type="document"/>
          <fp:field name="Two" domain="fp" type="document"/>
        </fp:field>

        <fp:field name="Schedule" domain="res" type="EventSchedule"/>
        <fp:field name="Access" type="variantAccess"/>
        <fp:field name="Timing" type="variantTiming"/>
        <fp:field name="Status" type="enumStatus"/>
        <fp:field name="CancelStatus" type="enumCancelStatus"/>

        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="Deny">
          <fp:flow/>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="Cancel">
          <fp:flow>
            <fp:set name="Status" value="Cancelled"/>
            <fp:switch host="Timing">
              <fp:branch>
                <fp:switch name="Before"/>
                <fp:flow>
                  <fp:set name="CancelStatus" value="Normal"/>
                </fp:flow>
              </fp:branch>
              <fp:branch>
                <fp:switch name="else"/>
                <fp:flow>
                  <fp:set name="CancelStatus" value="Late"/>
                </fp:flow>
              </fp:branch>
            </fp:switch>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="CancelAdmin">
          <fp:flow>
            <fp:set name="Status" value="Cancelled"/>
            <fp:set name="CancelStatus" value="Normal"/>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="Confirm">
          <fp:flow>
            <fp:switch host="Schedule/Seats">
              <fp:branch>
                <fp:switch name="Available"/>
                <fp:flow>
                  <fp:set name="Status" value="Confirmed"/>
                </fp:flow>
              </fp:branch>
              <fp:branch>
                <fp:switch name="else"/>
                <fp:flow>
                  <fp:failure name="NoSeatsAvailable"/>
                </fp:flow>
              </fp:branch>
            </fp:switch>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="Attend">
          <fp:flow>
            <fp:switch host="Access">
              <fp:branch>
                <fp:switch name="Denied"/>
                <fp:flow>
                  <fp:failure name="AccessDenied"/>
                </fp:flow>
              </fp:branch>
            </fp:switch>
            <fp:switch host="Status">
              <fp:branch>
                <fp:switch name="Confirmed"/>
                <fp:flow>
                  <fp:switch host="Timing">
                    <fp:branch>
                      <fp:switch name="During"/>
                      <fp:switch name="After"/>
                      <fp:flow>
                        <fp:set name="Status" value="Attended"/>
                        <fp:invoke obj="Schedule" name="Attend">
                          <fp:parameters>
                            <fp:param name="Id"/>
                          </fp:parameters>
                        </fp:invoke>
                      </fp:flow>
                    </fp:branch>
                    <fp:branch>
                      <fp:switch name="else"/>
                      <fp:flow>
                        <fp:failure name="InvalidTimimg"/>
                      </fp:flow>
                    </fp:branch>
                  </fp:switch>
                </fp:flow>
              </fp:branch>
              <fp:branch>
                <fp:switch name="else"/>
                <fp:flow>
                  <fp:failure name="InvalidStatus"/>
                </fp:flow>
              </fp:branch>
            </fp:switch>
          </fp:flow>
        </fp:function>
      </fp:document>

      <!-- +++ variant ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:variant name="variantAccess" id="learn/learning:variantAccess">
        <value name="Enabled"/>
        <value name="Denied"/>
      </fp:variant>

      <!-- +++ variant ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:variant name="variantTiming" id="learn/learning:variantTiming">
        <value name="Before"/>
        <value name="Short"/>
        <value name="During"/>
        <value name="After"/>
      </fp:variant>

      <!-- +++ variant ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:variant name="enumStatus" id="learn/learning:enumStatus">
        <value name="New"/>
        <value name="Confirmed"/>
        <value name="Denied"/>
        <value name="Cancelled"/>
        <value name="Attended"/>
      </fp:variant>

      <!-- +++ variant ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:variant name="enumCancelStatus" id="learn/learning:enumCancelStatus">
        <value name="Normal"/>
        <value name="Late"/>
      </fp:variant>

      <!-- +++ role ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:role name="Participant" id="learn/learning:Participant">
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="FindRequest">
          <fp:parameters>
            <fp:param dir="out" type="learn/learning:EnrollmentRequest" name="Request"/>
          </fp:parameters>
          <fp:flow>
            <fp:return name="Request" type="learn/learning:EnrollmentRequest"/>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="EnrollToClass">
          <fp:parameters>
            <fp:param type="learn/reservation:EventSchedule" name="Sch"/>
            <fp:param name="Request" dir="out" type="learn/learning:EnrollmentRequest"/>
          </fp:parameters>
          <fp:flow>
            <fp:produce name="Request" type="learn/learning:EnrollmentRequest">
              <fp:parameters>
                <fp:param name="Sch"/>
              </fp:parameters>
            </fp:produce>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="CancelRequest">
          <fp:parameters>
            <fp:param type="learn/learning:EnrollmentRequest" name="Request"/>
          </fp:parameters>
          <fp:flow>
            <fp:invoke obj="Request" name="Cancel"/>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="AttendEvent">
          <fp:parameters>
            <fp:param type="learn/learning:EnrollmentRequest" name="Request"/>
          </fp:parameters>
          <fp:flow/>
        </fp:function>
      </fp:role>

      <!-- +++ role ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:role name="Manager" id="learn/learning:Manager" parent="learn/learning:Participant">
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="EnrollSomeoneToClass">
          <fp:parameters>
            <fp:param name="Schedule"/>
          </fp:parameters>
          <fp:flow/>
        </fp:function>
      </fp:role>

      <!-- +++ role ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:role name="Admin" id="learn/learning:Admin" parent="learn/learning:Manager">
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="CreateEvent">
          <fp:parameters>
            <fp:param dir="out" name="Event1"/>
          </fp:parameters>
          <fp:flow>
            <fp:produce name="Event1"/>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="CreateSchedule">
          <fp:parameters>
            <fp:param name="Event1"/>
            <fp:param name="Schedule" dir="out"/>
          </fp:parameters>
          <fp:flow>
            <fp:produce name="Schedule" type="learn/reservation:EventSchedule">
              <fp:parameters>
                <fp:param name="Event1"/>
              </fp:parameters>
            </fp:produce>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="ApproveRequest">
          <fp:parameters>
            <fp:param type="learn/learning:EnrollmentRequest" name="Request"/>
          </fp:parameters>
          <fp:flow>
            <fp:invoke obj="Request" name="Confirm"/>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="DenyRequest">
          <fp:parameters>
            <fp:param type="learn/learning:EnrollmentRequest" name="Request"/>
          </fp:parameters>
          <fp:flow>
            <fp:invoke obj="Request" name="Deny"/>
          </fp:flow>
        </fp:function>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:function name="CancelRequest" ovr="CancelRequest">
          <fp:parameters>
            <fp:param type="learn/learning:EnrollmentRequest" name="Request"/>
          </fp:parameters>
          <fp:flow>
            <fp:switch>
              <fp:branch>
                <fp:switch name="1"/>
                <fp:flow>
                  <fp:invoke obj="Request" name="CancelAdmin"/>
                </fp:flow>
              </fp:branch>
              <fp:branch>
                <fp:switch name="2"/>
                <fp:flow>
                  <fp:invoke obj="Request" name="Cancel"/>
                </fp:flow>
              </fp:branch>
            </fp:switch>
          </fp:flow>
        </fp:function>
      </fp:role>
    </fp:artifacts>

    <!-- *** PROCESSES ***************************************************************  -->
    <fp:processes>
      <!-- +++ process ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:process name="AttendTheEvent" id="learn/learning:AttendTheEvent">
        <fp:field name="P" type="learn/learning:Participant"/>
        <fp:field name="Request" type="learn/learning:EnrollmentRequest"/>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name="EnrollStudent">
          <fp:flow>
            <fp:allocate name="DM" type="learn/learning:Manager"/>
            <fp:allocate name="Adm" type="learn/learning:Admin"/>
            <fp:switch>
              <fp:branch>
                <fp:switch name="1"/>
                <fp:flow>
                  <fp:invoke obj="P" name="EnrollToClass">
                    <fp:parameters>
                      <fp:param name="Schedule"/>
                      <fp:param name="Request"/>
                    </fp:parameters>
                  </fp:invoke>
                </fp:flow>
              </fp:branch>
              <fp:branch>
                <fp:switch name="2"/>
                <fp:flow>
                  <fp:invoke obj="DM" name="EnrollSomeoneToClass">
                    <fp:parameters>
                      <fp:param name="Schedule"/>
                      <fp:param name="Request"/>
                    </fp:parameters>
                  </fp:invoke>
                </fp:flow>
              </fp:branch>
              <fp:branch>
                <fp:switch name="3"/>
                <fp:flow>
                  <fp:invoke obj="Adm" name="EnrollSomeoneToClass">
                    <fp:parameters>
                      <fp:param name="Schedule"/>
                      <fp:param name="Request"/>
                    </fp:parameters>
                  </fp:invoke>
                </fp:flow>
              </fp:branch>
            </fp:switch>
          </fp:flow>
        </fp:task>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name="PossibleEvents">
          <fp:flow/>
        </fp:task>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name=".">
          <fp:parameters>
            <fp:param type="learn/reservation:EventSchedule" name="Schedule"/>
          </fp:parameters>
          <fp:flow>
            <fp:invoke name="EnrollStudent"/>
            <fp:wait name="Schedule/StartDate">
              <fp:flow>
                <fp:invoke name="PossibleEvents"/>
                <fp:onevent name="NeedToCancel">
                  <fp:flow>
                    <fp:invoke obj="P" name="CancelRequest">
                      <fp:parameters>
                        <fp:param name="Request"/>
                      </fp:parameters>
                    </fp:invoke>
                  </fp:flow>
                </fp:onevent>
                <fp:onevent name="EventHasBeenCancelled">
                  <fp:flow>
                    <fp:exit/>
                  </fp:flow>
                </fp:onevent>
              </fp:flow>
            </fp:wait>
          </fp:flow>
        </fp:task>
      </fp:process>

      <!-- +++ process ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:process name="ProvideTraining" id="learn/learning:ProvideTraining">
        <fp:field name="Adm" type="learn/learning:Admin"/>
        <fp:field name="Schedule" type="learn/reservation:EventSchedule"/>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name="ScheduleEvent">
          <fp:flow>
            <fp:invoke obj="Adm" name="CreateSchedule">
              <fp:parameters>
                <fp:param name="Ev"/>
                <fp:param name="Schedule"/>
              </fp:parameters>
            </fp:invoke>
          </fp:flow>
        </fp:task>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name="EnrollStudents">
          <fp:flow>
            <fp:many>
              <fp:flow>
                <fp:start name="AttendTheEvent">
                  <fp:parameters>
                    <fp:param name="Schedule"/>
                  </fp:parameters>
                </fp:start>
              </fp:flow>
            </fp:many>
          </fp:flow>
        </fp:task>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name=".">
          <fp:parameters>
            <fp:param type="learn/learning:Event1" name="Ev"/>
          </fp:parameters>
          <fp:flow>
            <fp:invoke name="ScheduleEvent"/>
            <fp:invoke name="EnrollStudents"/>
          </fp:flow>
        </fp:task>
      </fp:process>

      <!-- +++ process ++++++++++++++++++++++++++++++++++++++++++++++++ -->
      <fp:process name="ManageEvents" id="learn/learning:ManageEvents">
        <fp:field name="Adm" type="learn/learning:Admin"/>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name="RegisterEvent">
          <fp:parameters>
            <fp:param dir="out" type="learn/learning:Event1" name="Ev"/>
          </fp:parameters>
          <fp:flow>
            <fp:invoke obj="Adm" name="CreateEvent">
              <fp:parameters>
                <fp:param name="Ev"/>
              </fp:parameters>
            </fp:invoke>
          </fp:flow>
        </fp:task>
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <fp:task name=".">
          <fp:flow>
            <fp:many>
              <fp:flow>
                <fp:allocate name="Ev" type="learn/learning:Event1"/>
                <fp:invoke name="RegisterEvent">
                  <fp:parameters>
                    <fp:param name="Ev"/>
                  </fp:parameters>
                </fp:invoke>
                <fp:invoke name="ProvideTraining">
                  <fp:parameters>
                    <fp:param name="Ev"/>
                  </fp:parameters>
                </fp:invoke>
              </fp:flow>
            </fp:many>
          </fp:flow>
        </fp:task>
      </fp:process>
    </fp:processes>
  </fp:domain>
</fp:XI>