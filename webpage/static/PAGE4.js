
/* 
PAGE 4.HTML
IT HAS 3 FORMS
getroomno
updateregistration
deleteres
*/



/* 
#####################################################################################################################################

*/





/* 
PAGE 4.HTML
getroomno

*/


document.getElementById('getroomno').addEventListener('submit', async function(event) {
    event.preventDefault();
  
    const name = document.getElementById('name-3d0b').value;
    const regId = document.getElementById('text-c332').value;
  


    console.log('Form Data:', { name, reg_id: regId });

    
    const data = {
      name: name,
      reg_id: regId
    };
  

    console.log('Form Data:', { data });


    try {
      const response = await fetch('SERVELETS ID CRETED IN BACKEND', {
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
  








/* 
PAGE 4.HTML

updateregistration

*/


  document.getElementById('updateregistration').addEventListener('submit', async function(event) {
    event.preventDefault();
  
    const name = document.getElementById('name-3b9a').value;
    const CONTACT_NO = document.getElementById('CONTACT_NO').value;
    const ROOM_NO = document.getElementById('ROOM_NO').value;
  
    console.log('Form Data:', { name, ROOM_NO, CONTACT_NO });

    const data2 = {
      name: name,
      ROOM_NO: ROOM_NO,
      CONTACT_NO: CONTACT_NO
    };

    console.log('Form Data:', { data2 });

    try {
      const response = await fetch('SERVELETS ID CRETED IN BACKEND', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data2)
      });

      const result = await response.json();

      if (response.ok) {
        alert(`Success: ${result.success}`); // Show success message as popup
      } else {
        alert('Error: ' + (result.message || 'Something went wrong')); // Show error message as popup
      }
    } catch (error) {
      alert('Error: ' + error.message); // Show error message as popup
    }
  });















/* 
PAGE 1.HTML

deleteres
*/



  document.getElementById('deleteres').addEventListener('submit', async function(event) {
    event.preventDefault();
  
    const delregid = document.getElementById('delregid').value;
    
  
    console.log('Form Data:', { delregid});

    const data3 = {
        delregid: delregid
    };

    console.log('Form Data:', { data3 });

    try {
      const response = await fetch('SERVELETS ID CRETED IN BACKEND', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data3)
      });

      const result = await response.json();

      if (response.ok) {
        alert(`Success: ${result.success}`); // Show success message as popup
      } else {
        alert('Error: ' + (result.message || 'Something went wrong')); // Show error message as popup
      }
    } catch (error) {
      alert('Error: ' + error.message); // Show error message as popup
    }
  });
