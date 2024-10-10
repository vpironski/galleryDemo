<script>
    import { onMount } from 'svelte';
    import { getPaintingById } from '$lib/api.js';
    import { page } from '$app/stores';
    import {goto} from "$app/navigation";
    let painting = null;
    let error = null;

    onMount(async () => {
        try {
            const  id  = $page.params.id;
            console.log("Page params:", $page.params);

            painting = await getPaintingById(id);
            console.log("Fetched painting:", painting);
        } catch (err) {
            console.error('Error fetching painting:', err);
            error = err.message;
        }
    });

    function handleBack() {
        goto('/get');
    }
</script>

{#if error}
    <p>{error}</p>
{:else if (!painting)}
    <p>Loading...</p>
{:else}
    <div class=" flex items-center justify-center w-full dark:bg-gray-950">
        <div class="bg-white dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 max-w-md">
                <div class="mb-4 text-center">
                    <h2 class="text-3xl font-bold">{painting.name}</h2>
                </div>
                <div class="mb-4 text-center">
                    <p>{painting.artist}</p>
                </div>
                <div class="mb-4 text-center">
                    <p>{painting.description}</p>
                </div>

                <button on:click={handleBack} class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Back to List</button>
        </div>
    </div>
{/if}


