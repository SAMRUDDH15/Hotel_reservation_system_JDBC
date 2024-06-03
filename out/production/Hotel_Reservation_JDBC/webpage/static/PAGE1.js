
/* 
PAGE 1.HTML
reserve

RESERVING A ROOM BY ENTERING GUEST NAME , PHONE NO ,ROOM NO
*/


document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById('reserve');
    if (!form) {
        console.error("Form element with ID 'form' not found.");
        return;
    }




    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission
        
        // Collect form data
        var formData = {
            name = document.getElementById('name-6797').value,
            PHONERES = document.getElementById('PHONERES').value,
            ROOMNO = document.getElementById('ROOMNO').value
        };


         // Log the data being sent
        console.log("Data being sent:", formData);

        try {
            const response = await fetch('https://your-backend-java-app-url', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify(data)
            });
        
            const result = await response.json();
        
            if (response.ok) {
              document.getElementById('successMessage').style.display = 'block';
              document.getElementById('errorMessage').style.display = 'none';
      
              roomNumber=100;
      
              document.getElementById('roomNumber').innerText = `ROOM NO: ${result.roomNumber}`;
            } else {
              document.getElementById('successMessage').style.display = 'none';
              document.getElementById('errorMessage').style.display = 'block';
            }
          } catch (error) {
            document.getElementById('successMessage').style.display = 'none';
            document.getElementById('errorMessage').style.display = 'block';
          }
        });
        