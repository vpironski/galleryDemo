<script>
    import { onMount } from 'svelte';
    import { deletePainting} from '$lib/api.js';
    import { goto } from '$app/navigation';
    import { page } from '$app/stores';

    let painting = null;
    let message = '';
    let error = '';

    onMount(async () => {
        try {
            let id = $page.params.id;
            const result = await deletePainting(id);
            console.log("Delete response:", result);
            message = result.message || 'Painting deleted successfully!';
        } catch (err) {
            console.error('Error deleting painting:', err);
            error = 'Failed to delete painting: ' + err.message;
        }
    });

    function handleBack() {
        goto('/delete');
    }
</script>

<div class="flex items-center justify-center w-full dark:bg-gray-950">
    <div class="bg-white dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 max-w-md">
        <div class="text-center">
            {#if error}
                <h1 class="mt-5 error">{error}</h1>
            {:else if (message)}
                <h1 class="mt-5 message">{message}</h1>
            {/if}
        </div>
        <button on:click={handleBack} class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Back to List</button>
    </div>
</div>
