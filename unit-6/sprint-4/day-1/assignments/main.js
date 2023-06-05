function sendEmail() {
  const recipient = "ankitsingh40068@gmail.com";
  const subject = "Test email";
  const body = "This is a test email sent using JavaScript!";
  window.location.href = `mailto:${recipient}?subject=${subject}&body=${body}`;
}


sendEmail();