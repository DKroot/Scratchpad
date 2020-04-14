type FieldFailure = { failedOnField?: string; };
type ValidationFailureDetails =
 { annualLeave?: string; }
 | { availableHours?: any[]; }
 | { availableHoursSummary?: string; }
 | { startDate?: string; }
 | { endDate?: string; }
 | FieldFailure
 | { pErrors?: any; }
 | { formErrors?: any; }
 | { todBaseView?: any; }
 | { tourOfDuty?: any; }
 | { key?: any; }
 | { errObj?: any; }
 | { shiftsApplicable?: boolean; };

// Type guard
function isFieldFailure(failureDetails: ValidationFailureDetails): failureDetails is FieldFailure {
  return (failureDetails as FieldFailure).failedOnField !== undefined;
}

class ErrorReport {
  timestamp?: string; // ISO date/time
  message: string;
  status?: number;
  path?: string;
  details: ValidationFailureDetails & { // Unexpected error details
    rootCause?: any;
  };

  constructor(responseData: Partial<ErrorReport>, status?: number) {
    if (!responseData.message) {
      // Got the error message as the response body
      this.details = {
        rootCause: (responseData as any)
      };
    } else {
      Object.assign(this, responseData); // ES6 / ES2015
    }

    if (status) {
      this.status = status;
    }

    if (!this.timestamp) {
      this.timestamp = new Date().toISOString();
    }
  }

  static of(message: string, previousReport: ErrorReport | null, error?: Error, path?: string): ErrorReport {
    const result = new ErrorReport({
      message,
      path
    });
    if (error) {
      let rootCause = error.stack;
      if (previousReport) {
        rootCause += "\n\nReported failure:\n" + previousReport.message +
            (previousReport.details?.rootCause ? "\nCaused by \n" + previousReport.details?.rootCause : "");
      }
      result.details = {
        rootCause
      };
    }
    return result;
  }
}

const failure = {
  message: "Wrong data",
  details: {
    failedOnField: "field `foo`"
  }
};
const errReport = new ErrorReport(failure);
console.info("\nError report =", errReport);

// Narrowing union type using a type assertion
if ((errReport.details as FieldFailure).failedOnField) {
  console.info("\ndetails.failedOnField =", (errReport.details as FieldFailure).failedOnField);
}

// Narrowing union type using a type guard
if (isFieldFailure(errReport.details)) {
  console.info("\ndetails.failedOnField =", errReport.details.failedOnField);
}

const failure2 = new Error("Failed completely!");
failure2.stack =
    "TypeError: Cannot read property 'length' of undefined\n" + "\tat {Class}.{method} ({location}:{line}:{column})" +
    "\tat {Class}.{method} ({location}:{line}:{column})" + "\tat http://{app}/{script}.js:{line}:{column}";
const errReport2 = ErrorReport.of(failure2.message, errReport, failure2);
console.info("\nError report =", errReport2);
