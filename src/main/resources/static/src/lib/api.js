// static/src/lib/api.js
export async function getAllPaintings() {
    const response = await fetch('/api/get');

    if (!response.ok) {
        throw new Error('Failed to fetch paintings');
    }
    return await response.json();
}

export async function getPaintingById(id) {
    console.log("ID received:", id);
    const response = await fetch(`/api/get/${id}`);
    console.log("Fetch URL:", `/api/get/${id}`);

    if (!response.ok) {
        console.error("Failed to fetch painting:", response.statusText);
        throw new Error('Failed to fetch painting');
    }

    const data = await response.json();
    console.log("Fetched painting data:", data);
    return data;
}


export async function createPainting(painting) {
    const response = await fetch('/api/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(painting)
    });
    if (!response.ok) {
        throw new Error('Failed to create painting');
    }
    return await response.json();
}

export async function deletePainting(id) {
    const response = await fetch(`/api/delete/${id}`, {
        method: 'DELETE'
    });

    if (!response.ok) {
        throw new Error('Failed to delete painting');
    }

    // Check if the response has a body
    try {
        const result = await response.json();
        return result;
    } catch (err) {
        // If there's no JSON response, we assume the delete was successful
        return { message: 'Painting deleted' };
    }
}


export async function updatePainting(painting) {
    try {
        const response = await fetch(`/api/update/${painting.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(painting)
        });

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(`Failed to update painting: ${errorMessage}`);
        }

        return await response.json();
    } catch (error) {
        console.error('Error updating painting:', error);
        throw error;
    }
}
