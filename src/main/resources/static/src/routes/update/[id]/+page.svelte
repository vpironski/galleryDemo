<script>
    import { updatePainting, getPaintingById } from '$lib/api.js'; // Assuming getPainting is a function to fetch painting details
    import { onMount } from 'svelte';
    import { writable } from 'svelte/store';
    import { page } from '$app/stores';
    import {goto} from "$app/navigation";

    let name = '';
    let artist = '';
    let description = '';
    let error = writable('');
    let success = writable('');
    const { id } = $page.params;

    onMount(async () => {
        try {
            const oldPainting = await getPaintingById(id);
            name = oldPainting.name;
            artist = oldPainting.artist;
            description = oldPainting.description;
        } catch (err) {
            console.error('Failed to load painting details', err);
            error.set('Failed to load painting details');
        }
    });

    async function handleSubmit(event) {
        event.preventDefault();
        error.set('');
        success.set('');

        try {
            const painting = {id, name, artist, description };
            const response = await updatePainting(painting);
            success.set('Painting updated successfully!');
        } catch (err) {
            error.set(`Failed to update painting: ${err.message}`);
        }
    }

    function handleBack() {
        goto('/update');
    }
</script>


<div class="flex items-center justify-center w-full dark:bg-gray-950">
    <div class="bg-white dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 max-w-md">
        <form on:submit={handleSubmit} >
            <h1 class="text-2xl font-bold text-center mb-4 dark:text-gray-200">Add Painting</h1>
            <div class="mb-4">
                <label for="name" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Painting name</label>
                <input bind:value={name} type="text" id="name" class="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" placeholder="Name"   required>
            </div>
            <div class="mb-4">
                <label for="artist" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Artist</label>
                <input bind:value={artist}  type="text" id="artist" class="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" placeholder="Artist" required>
            </div>
            <div class="mb-4">
                <label for="description" class="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Description</label>
                <textarea bind:value={description}  type="text" id="description" class="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" placeholder="Description" required></textarea>
            </div>

            <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Update Painting</button>
        </form>
        <div class="text-center">
            {#if $error}
                <h1 class="mt-5 error">{$error}</h1>
                <button on:click={handleBack} class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Back to List</button>
            {/if}
            {#if $success}
                <h1 class="mt-5 message">{$success}</h1>
                <button on:click={handleBack} class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Back to List</button>
            {/if}
        </div>
    </div>
</div>