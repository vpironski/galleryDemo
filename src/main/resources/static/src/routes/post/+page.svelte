<script>
    import { createPainting } from '$lib/api.js';
    import { writable } from 'svelte/store';
    import {goto} from "$app/navigation";

    let name = '';
    let artist = '';
    let description = '';
    let error = writable('');
    let success = writable('');

    async function handleSubmit(event) {
        event.preventDefault();
        error.set('');
        success.set('');

        try {
            const painting = { name, artist, description };
            const response = await createPainting(painting);
            success.set('Painting created successfully!');
            name = '';
            artist = '';
            description = '';
        } catch (err) {
            error.set('Failed to create painting');
        }
    }
</script>
<!-- component -->
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

            <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Create Painting</button>
        </form>
        <div class="text-center">
            {#if $error}
                <h1 class="mt-5">{$error}</h1>
            {/if}
            {#if $success}
                <h1 class="mt-5">{$success}</h1>
            {/if}
        </div>
    </div>
</div>

