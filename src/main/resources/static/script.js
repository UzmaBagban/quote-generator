// Get HTML elements
const nameInput = document.getElementById('nameInput');
const getQuoteBtn = document.getElementById('getQuoteBtn');
const quoteSection = document.getElementById('quoteSection');
const quoteMessage = document.getElementById('quoteMessage');
const quoteObject = document.getElementById('quoteObject');
const quoteAuthor = document.getElementById('quoteAuthor');
const errorMessage = document.getElementById('errorMessage');

// Add click listener to button
getQuoteBtn.addEventListener('click', getQuote);

// Allow Enter key to trigger getQuote
nameInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        getQuote();
    }
});

// Function to fetch quote from API
async function getQuote() {
    const name = nameInput.value || 'Friend';

    try {
        // Call your Spring Boot API
        const response = await fetch(`/api/quotes/hello?name=${name}`);

        // Check if request was successful
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        // Parse JSON response
        const data = await response.json();

        // DEBUG: Log what we received
        console.log('API Response:', data);

        // Display the quote (data is a Quote object directly)
        quoteMessage.textContent = data.content;
        quoteAuthor.textContent = `— ${data.author}`;

        // Show quote section, hide error
        quoteSection.classList.remove('hidden');
        errorMessage.classList.add('hidden');

    } catch (error) {
        // Show error message
        console.error('Error details:', error);
        errorMessage.textContent = `Error: ${error.message}`;
        errorMessage.classList.remove('hidden');
        quoteSection.classList.add('hidden');
    }
}