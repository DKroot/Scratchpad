class EmailOptions {
  constructor(fields:Partial<EmailOptions> & {replyTo: EmailOptions['replyTo']}) {
    // Do some work in constructor

    Object.assign(this, fields); // ES6 / ES2015
  }

  replyTo: string; // Required field
  fromName?: string;
  fromEmail?: string;
  templateName?: string;

  nameWithEmail() {
    return `${this.fromName} <${this.fromEmail}>`;
  }
}

let opts = new EmailOptions({
  replyTo: 'me@example.com',
  fromName: 'John Doe',
  fromEmail: 'john.doe@example.com'
});

console.info('Opts=', opts, 'instanceof EmailOptions ?', opts instanceof EmailOptions);
console.info('nameWithEmail=', opts.nameWithEmail());