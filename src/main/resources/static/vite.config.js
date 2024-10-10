import { sveltekit } from '@sveltejs/kit/vite';
import { defineConfig } from 'vite';

export default defineConfig({
	plugins: [sveltekit()],
	css: {
		postcss: './postcss.config.cjs',
	},
	server: { // localhost:8080/get -> localhost:5173/api/get
		proxy: {
			'/api': {
				target: 'http://localhost:8080',
				changeOrigin: true,
				rewrite: path => path.replace(/^\/api/, '')
			}
		}
	},
	optimizeDeps: {
		exclude: [
			'/node_modules/.vite/deps/chunk-WI4AAJO7.js' // Adjust the path accordingly
		]
	}
});

