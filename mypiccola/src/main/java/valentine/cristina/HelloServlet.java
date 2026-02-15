package valentine.cristina;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = {"/Cristina", "/crisitina"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("""
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Cristina, Be My Valentine</title>
                    <style>
                        :root {
                            --bg: #fff0f3;
                            --card: #ffffff;
                            --text: #2b0f18;
                            --yes: #1f9d55;
                            --no: #d64545;
                        }
                        body {
                            margin: 0;
                            min-height: 100vh;
                            display: grid;
                            place-items: center;
                            overflow: hidden;
                            font-family: "Segoe UI", Tahoma, sans-serif;
                            background: radial-gradient(circle at top, #ffd6e0, var(--bg) 60%);
                            color: var(--text);
                        }
                        .card {
                            width: min(92vw, 560px);
                            background: var(--card);
                            border-radius: 18px;
                            padding: 36px 28px;
                            text-align: center;
                            box-shadow: 0 14px 40px rgba(113, 12, 45, 0.16);
                        }
                        .hero-gif {
                            width: min(88vw, 320px);
                            border-radius: 14px;
                            margin-bottom: 16px;
                        }
                        h1 {
                            margin-top: 0;
                            font-size: clamp(1.5rem, 4vw, 2.2rem);
                        }
                        .actions {
                            display: flex;
                            justify-content: center;
                            gap: 12px;
                            flex-wrap: wrap;
                        }
                        button {
                            border: 0;
                            border-radius: 10px;
                            color: #fff;
                            padding: 12px 24px;
                            font-size: 1rem;
                            cursor: pointer;
                            transition: all 180ms ease-in-out;
                        }
                        .yes-btn { background: var(--yes); }
                        .no-btn { background: var(--no); }
                        .reply {
                            margin: 18px 0 0;
                            font-weight: 600;
                            min-height: 24px;
                        }
                        .reply.yes { color: var(--yes); }
                        .reply.no { color: var(--no); }
                        .yes-only-overlay {
                            position: fixed;
                            inset: 0;
                            display: none;
                            align-items: center;
                            justify-content: center;
                            text-align: center;
                            z-index: 5000;
                            pointer-events: none;
                            box-sizing: border-box;
                            padding: 3vh 4vw;
                        }
                        .yes-only-overlay.show {
                            display: flex;
                        }
                        .yes-tech-text {
                            width: min(92vw, 760px);
                            font-size: clamp(1.4rem, 3.9vw, 2.8rem);
                            font-weight: 800;
                            letter-spacing: 0.03em;
                            line-height: 1.24;
                            margin: 0;
                            background: linear-gradient(90deg, #00f0ff, #29ffb4, #ffe066, #ff6adf, #9d4dff, #00f0ff);
                            background-size: 220% 100%;
                            -webkit-background-clip: text;
                            background-clip: text;
                            color: transparent;
                            text-transform: none;
                            text-shadow:
                                0 1px 0 rgba(6, 10, 26, 0.45),
                                0 0 8px rgba(0, 240, 255, 0.35),
                                0 0 14px rgba(255, 106, 223, 0.25);
                            -webkit-text-stroke: 0.35px rgba(10, 10, 10, 0.35);
                            animation: technoPulse 1.6s ease-in-out infinite alternate, technoFlow 5s linear infinite;
                        }
                        .yes-overlay-content {
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                            justify-content: flex-start;
                            gap: 14px;
                            width: min(92vw, 700px);
                            max-height: 94vh;
                        }
                        .yes-overlay-gif {
                            display: block;
                            width: min(78vw, 340px);
                            max-height: 42vh;
                            object-fit: contain;
                            border-radius: 14px;
                            margin: 0 auto;
                            box-shadow: 0 0 14px rgba(0, 240, 255, 0.35), 0 0 30px rgba(255, 106, 223, 0.3);
                        }
                        .no-sticker {
                            position: fixed;
                            width: clamp(95px, 14vw, 180px);
                            height: auto;
                            pointer-events: none;
                            user-select: none;
                            z-index: 1300;
                            filter: drop-shadow(0 8px 16px rgba(0, 0, 0, 0.3));
                            animation: stickerAppear 200ms ease-out forwards;
                        }
                        .celebration-item {
                            position: fixed;
                            top: -14vh;
                            pointer-events: none;
                            z-index: 2000;
                            animation-name: fall;
                            animation-timing-function: linear;
                            animation-fill-mode: forwards;
                        }
                        .balloon {
                            position: relative;
                            width: 22px;
                            height: 30px;
                            border-radius: 50% 50% 45% 45%;
                        }
                        .balloon::after {
                            content: "";
                            position: absolute;
                            left: 50%;
                            top: 30px;
                            width: 2px;
                            height: 22px;
                            transform: translateX(-50%);
                            background: rgba(255, 255, 255, 0.7);
                        }
                        .ribbon {
                            width: 8px;
                            height: 28px;
                            border-radius: 999px;
                        }
                        .emoji-celebration {
                            width: auto;
                            height: auto;
                            font-size: clamp(1.2rem, 2.8vw, 2rem);
                            line-height: 1;
                            filter: drop-shadow(0 0 8px rgba(255, 255, 255, 0.75));
                            user-select: none;
                        }
                        .explosion-fragment {
                            position: fixed;
                            width: 6px;
                            height: 6px;
                            border-radius: 50%;
                            pointer-events: none;
                            z-index: 2100;
                            animation-name: explode;
                            animation-timing-function: ease-out;
                            animation-fill-mode: forwards;
                        }
                        @keyframes fall {
                            to {
                                transform: translateY(120vh) rotate(420deg);
                                opacity: 0.9;
                            }
                        }
                        @keyframes explode {
                            from {
                                transform: translate(0, 0) scale(1.1);
                                opacity: 1;
                            }
                            to {
                                transform: translate(var(--dx), var(--dy)) scale(0);
                                opacity: 0;
                            }
                        }
                        @keyframes stickerAppear {
                            from {
                                opacity: 0;
                            }
                            to {
                                opacity: 1;
                            }
                        }
                        @keyframes technoPulse {
                            0% {
                                transform: translateY(0) scale(1);
                            }
                            100% {
                                transform: translateY(-2px) scale(1.01);
                            }
                        }
                        @keyframes technoFlow {
                            from {
                                background-position: 0% 50%;
                            }
                            to {
                                background-position: 220% 50%;
                            }
                        }
                        @media (max-height: 640px) {
                            .yes-overlay-content {
                                gap: 10px;
                            }
                            .yes-overlay-gif {
                                max-height: 34vh;
                            }
                            .yes-tech-text {
                                font-size: clamp(1.2rem, 3.4vw, 2.2rem);
                                line-height: 1.2;
                            }
                        }
                    </style>
                </head>
                <body>
                    <main class="card">
                        <img id="heroGif" class="hero-gif" src="https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExZ3d5YXZjemh2emo4ZXh2b3hkN3Vvcm5pbnNsMGxmb2h6dmV5MTBhbSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/g0ou7QvBa5MSexh8jv/giphy.gif" alt="Valentine gif">
                        <h1>Cristina, will you Always be my Valentine?</h1>
                        <div class="actions">
                            <button id="yesBtn" class="yes-btn" type="button">Yes</button>
                            <button id="noBtn" class="no-btn" type="button">No</button>
                        </div>
                        <p id="reply" class="reply" aria-live="polite"></p>
                    </main>
                    <div id="yesOnlyOverlay" class="yes-only-overlay" aria-live="polite">
                        <div class="yes-overlay-content">
                            <img class="yes-overlay-gif" src="https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExdnp3a3A2MjE2ZmdnMzg0NjBkZXJ5cnJ1ejd3cXU0MXp2d2UzZm5kNyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/KD1D49tK4Hvl6E5q1T/giphy.gif" alt="Yes celebration">
                            <p class="yes-tech-text">You Don`t Have Other Options, You Will Always Be My Valeinte</p>
                        </div>
                    </div>
                    <script>
                        (() => {
                            const yesBtn = document.getElementById("yesBtn");
                            const noBtn = document.getElementById("noBtn");
                            const reply = document.getElementById("reply");
                            const card = document.querySelector(".card");
                            const yesOnlyOverlay = document.getElementById("yesOnlyOverlay");
                            let noClicks = 0;
                            let celebrationTimer = null;
                            const colors = ["#ff4d6d", "#ffd166", "#06d6a0", "#4cc9f0", "#ff85a1", "#f48c06"];
                            const celebrationEmojis = ["😘", "😍"];
                            const stickerSrc = "IMAge.png";
                            const noMessages = [
                                "My love, are you sure?!",
                                "My looooooveeeee?! 😨",
                                "Myyyyyyyyy looooooooooooove. Think again.",
                                "Piccolaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!",
                                "Puiuuuuuuuuuuuuuuuuuuuuuuuu!",
                                "My love, let's be calm and think again.",
                                "Piccola, are you sure you have your glasses?",
                                "Maybe try cleaning your glasses.",
                                "My love, first go drink a glass of water."
                            ];

                            function createExplosionAt(x, y, color) {
                                const fragments = 10;

                                for (let i = 0; i < fragments; i++) {
                                    const fragment = document.createElement("div");
                                    const angle = Math.random() * Math.PI * 2;
                                    const distance = 24 + Math.random() * 56;
                                    const dx = Math.cos(angle) * distance;
                                    const dy = Math.sin(angle) * distance;

                                    fragment.className = "explosion-fragment";
                                    fragment.style.left = x + "px";
                                    fragment.style.top = y + "px";
                                    fragment.style.background = color;
                                    fragment.style.setProperty("--dx", dx + "px");
                                    fragment.style.setProperty("--dy", dy + "px");
                                    fragment.style.animationDuration = (0.45 + Math.random() * 0.35) + "s";

                                    document.body.appendChild(fragment);
                                    setTimeout(() => fragment.remove(), 850);
                                }
                            }

                            function spawnRainBatch(count) {
                                for (let i = 0; i < count; i++) {
                                    const item = document.createElement("div");
                                    const modeRoll = Math.random();
                                    const isEmoji = modeRoll < 0.28;
                                    const isBalloon = !isEmoji && modeRoll > 0.58;
                                    item.className = "celebration-item " + (isEmoji ? "emoji-celebration" : (isBalloon ? "balloon" : "ribbon"));
                                    item.style.left = Math.random() * 100 + "vw";
                                    const burstColor = colors[Math.floor(Math.random() * colors.length)];
                                    item.style.background = burstColor;
                                    item.dataset.explosionColor = burstColor;
                                    item.style.animationDuration = (3.2 + Math.random() * 3.8) + "s";
                                    item.style.opacity = String(0.75 + (Math.random() * 0.25));
                                    item.style.transform = "translateY(-14vh) rotate(" + Math.floor(Math.random() * 180) + "deg)";

                                    if (isEmoji) {
                                        item.style.background = "transparent";
                                        item.textContent = celebrationEmojis[Math.floor(Math.random() * celebrationEmojis.length)];
                                    } else if (!isBalloon) {
                                        item.style.width = (5 + Math.random() * 7) + "px";
                                        item.style.height = (20 + Math.random() * 24) + "px";
                                    }

                                    item.addEventListener("animationend", () => {
                                        const rect = item.getBoundingClientRect();
                                        const x = rect.left + (rect.width / 2);
                                        const y = Math.min(window.innerHeight - 14, rect.top + (rect.height / 2));
                                        createExplosionAt(x, y, item.dataset.explosionColor || item.style.background);
                                        item.remove();
                                    });

                                    document.body.appendChild(item);
                                }
                            }

                            function startCelebration() {
                                if (celebrationTimer !== null) {
                                    return;
                                }

                                spawnRainBatch(24);
                                celebrationTimer = setInterval(() => {
                                    spawnRainBatch(14);
                                }, 220);
                            }

                            function dropNoSticker() {
                                const sticker = document.createElement("img");
                                const stickerSize = 105 + Math.random() * 95;

                                sticker.className = "no-sticker";
                                sticker.src = stickerSrc;
                                sticker.alt = "Sticker";
                                sticker.style.width = stickerSize + "px";

                                const maxX = Math.max(0, window.innerWidth - stickerSize);
                                const maxY = Math.max(0, window.innerHeight - stickerSize);
                                const randomX = Math.floor(Math.random() * (maxX + 1));
                                const randomY = Math.floor(Math.random() * (maxY + 1));
                                const randomRotation = -20 + (Math.random() * 40);

                                sticker.style.left = randomX + "px";
                                sticker.style.top = randomY + "px";
                                sticker.style.transform = "rotate(" + randomRotation.toFixed(1) + "deg)";

                                document.body.appendChild(sticker);
                            }

                            yesBtn.addEventListener("click", () => {
                                reply.textContent = "";
                                reply.className = "reply";
                                card.style.display = "none";
                                yesOnlyOverlay.classList.add("show");
                                startCelebration();
                            });

                            noBtn.addEventListener("click", () => {
                                noClicks += 1;
                                dropNoSticker();

                                if (noClicks >= 10) {
                                    reply.textContent = "My  love , you cant run , You are Mine . M - I - N - E";
                                    reply.className = "reply no";
                                    noBtn.remove();
                                    return;
                                }

                                const messageIndex = (noClicks - 1) % noMessages.length;
                                reply.textContent = noMessages[messageIndex];
                                reply.className = "reply no";

                                noBtn.style.position = "fixed";
                                noBtn.style.zIndex = "1000";
                                noBtn.style.transform = "none";

                                const buttonRect = noBtn.getBoundingClientRect();
                                const maxX = Math.max(0, window.innerWidth - buttonRect.width);
                                const maxY = Math.max(0, window.innerHeight - buttonRect.height);
                                const randomX = Math.floor(Math.random() * (maxX + 1));
                                const randomY = Math.floor(Math.random() * (maxY + 1));
                                noBtn.style.left = randomX + "px";
                                noBtn.style.top = randomY + "px";
                            });
                        })();
                    </script>
                </body>
                </html>
                """);
    }
}
